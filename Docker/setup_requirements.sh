#!/bin/sh
# 
#    Copyright (C) 2018 Modelon AB
#
#    This program is free software: you can redistribute it and/or modify
#    it under the terms of the Common Public License as published by
#    IBM, version 1.0 of the License.
#
#    This program is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY. See the Common Public License for more details.
#
#    You should have received a copy of the Common Public License
#    along with this program.  If not, see
#     <http://www.ibm.com/developerworks/library/os-cpl.html/>.

/Docker/build/settings.sh

BUILD_PKGS_JM_COMMON="cmake swig ant wget tar patch"
BUILD_PKGS_JM_REDHAT="lucene which subversion-devel gcc-c++ gcc-gfortran python-ipython java-1.8.0-openjdk python-devel numpy scipy matplotlib Cython python-lxml python-nose python-jpype zlib-devel boost-devel"
BUILD_PKGS_JM_DEBIAN="jcc python-lucene subversion g++ gfortran ipython openjdk-8-jdk python-dev python-numpy python-scipy python-matplotlib cython python-lxml python-nose python-jpype zlib1g-dev libboost-dev"

if [ "$LINUX_DISTRIBUTION" == "CENTOS" ]; then
	BUILD_PKGS_JM=$BUILD_PKGS_JM_REDHAT
	alias pckinstall="yum -y install"
elif [ "$LINUX_DISTRIBUTION" == "REDHAT" ]; then 
	BUILD_PKGS_JM=$BUILD_PKGS_JM_REDHAT
	alias pckinstall="yum -y install"
elif [ "$LINUX_DISTRIBUTION" == "DEBIAN" ]; then 
	BUILD_PKGS_JM=$BUILD_PKGS_JM_DEBIAN
	apt-get update 
	alias pckinstall="apt-get -y install"
else 
	echo ERROR: current linux distribution not supported yet 
fi

# echo Linux Distribution : $LINUX_DISTRIBUTION

pckinstall $BUILD_PKGS_JM_COMMON
pckinstall $BUILD_PKGS_JM


