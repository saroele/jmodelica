// This loads the Jenkins pipeline library found in the ci folder.
def url = scm.getLocations()[0].remote
library identifier: 'JModelica@ci', retriever: modernSCM([$class: 'SubversionSCMSource', remoteBase: url, credentialsId: ''])

def JM_BRANCH = "trunk"
def JMODELICA_SDK_HOME="C:\\JModelica.org-SDK-1.13\\"

// Set build name:
currentBuild.displayName += " (" + (env.TRIGGER_CAUSE == null ? "MANUAL" : env.TRIGGER_CAUSE) + ")"

// Set discard policy
properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '5', daysToKeepStr: '', numToKeepStr: ''))])

node ("716KS42") {
    dir ('Build') {
        stage("Checkout JModelica.org") {
            checkout([
                $class: 'SubversionSCM',
                locations: [
                    [local: 'JModelica',          remote: "https://svn.jmodelica.org/${JM_BRANCH}",                         credentialsId: ''],
                ],
                workspaceUpdater: [$class: 'UpdateWithCleanUpdater']
            ])
        }
        
        
                stage("Build install folder") {
            runMSYSWithEnv("""\
WORKSPACE="\$(pwd)"
JM_CO_DIR=\${WORKSPACE}/JModelica/
export SRC_HOME=\${JM_CO_DIR}
export BUILD_HOME=\${WORKSPACE}/build
export INSTALL_HOME=\${WORKSPACE}/install
cd "${unixpath(JMODELICA_SDK_HOME)}"
echo ==== Run configure
./configure.sh
echo ==== Go to build and run make
cd "\${BUILD_HOME}"
make
make install
if [ "\${BUILD_CASADI:-1}" == "1" ]; then
    make casadi_interface
fi
""","""\
set WORKSPACE=${pwd()}
set IN_HEADLESS=1
set BUILD_CASADI=1
""")
        }
        stage("Archive") {
            archive 'install/**'
            
            // Prepare the ZIP for future upload
            jmRevision=svnRevision("JModelica")
            def zipName="JModelica.org-Chicago-win-r${jmRevision}.zip"
            def readMeContents = libraryResource 'installZip_README.TXT'
            writeFile file: 'README.TXT', text: readMeContents
            runMSYSWithEnv("""\
rm -f *.zip
zip -r "${zipName}" install README.TXT
""")
           stash includes: '*.zip', name: 'installZip'
        }
        
        stage("Run jm_tests") {
            try {
            runMSYSWithEnv("""\
TEST_RES_DIR=\${WORKSPACE}/testRes
mkdir -p "\${TEST_RES_DIR}"
install/jm_tests -ie -x "\${TEST_RES_DIR}"
""")
            } finally {
                junit testResults: 'testRes/*.xml', allowEmptyResults: true
            }
        }
    }
}
// We need to run on master since we need a linux server with ssh-agent support
node ('master') {
    stage ('Upload') {
        deleteDir()
        sshagent(['jmodelica.org']) {
            unstash 'installZip'
            sh 'scp *.zip jenkins@jmodelica.org:/srv/www/htdocs/downloads/nightly-builds'
        }
        deleteDir()
    }
}