/*
    Copyright (C) 20019 Modelon AB

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3 of the License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/


package CCodeGenCompositeStatementTests

    model RecordStmt1
        record R
            Real x;
        end R;
        
        function f
            input R r;
            constant R c(x=1);
            output R[:] y = {c, r};
        algorithm
        end f;
        
        R[:] r = f(R(time));

annotation(__JModelica(UnitTesting(tests={
    CCodeGenTestCase(
        name="RecordStmt1",
        description="",
        template="
$C_functions$
",
        generatedCode="
void func_CCodeGenCompositeStatementTests_RecordStmt1_f_def0(R_0_r* r_v, R_0_ra* y_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARR(STACK, R_0_r, R_0_ra, y_an, 2, 1)
    JMI_ARR(STACK, R_0_r, R_0_ra, temp_1_a, 2, 1)
    jmi_real_t i1_0i;
    jmi_int_t i1_0ie;
    jmi_int_t i1_0in;
    if (y_a == NULL) {
        JMI_ARRAY_INIT_1(STACK, R_0_r, R_0_ra, y_an, 2, 1, 2)
        y_a = y_an;
    }
    JMI_ARRAY_INIT_1(STACK, R_0_r, R_0_ra, temp_1_a, 2, 1, 2)
    *jmi_array_rec_1(temp_1_a, 1) = *JMI_GLOBAL(CCodeGenCompositeStatementTests_RecordStmt1_f_c);
    *jmi_array_rec_1(temp_1_a, 2) = *r_v;
    i1_0in = 0;
    i1_0ie = floor((2) - (1));
    for (i1_0i = 1; i1_0in <= i1_0ie; i1_0i = 1 + (++i1_0in)) {
        jmi_array_rec_1(y_a, i1_0i)->x = jmi_array_rec_1(temp_1_a, i1_0i)->x;
    }
    JMI_DYNAMIC_FREE()
    return;
}
")})));
    end RecordStmt1;

    model RecordStmt2
        record R
            Real[1] x;
        end R;
        
        function f
            input R r;
            constant R c(x={1});
            output R[:] y = {c, r};
        algorithm
        end f;
        
        R[:] r = f(R({time}));

annotation(__JModelica(UnitTesting(tests={
    CCodeGenTestCase(
        name="RecordStmt2",
        description="",
        template="
$C_functions$
",
        generatedCode="
void func_CCodeGenCompositeStatementTests_RecordStmt2_f_def0(R_0_r* r_v, R_0_ra* y_a) {
    JMI_DYNAMIC_INIT()
    JMI_ARR(STACK, R_0_r, R_0_ra, y_an, 2, 1)
    JMI_ARR(STACK, jmi_real_t, jmi_array_t, tmp_1, 1, 1)
    JMI_ARR(STACK, jmi_real_t, jmi_array_t, tmp_2, 1, 1)
    JMI_ARR(STACK, R_0_r, R_0_ra, temp_1_a, 2, 1)
    jmi_real_t i1_0i;
    jmi_int_t i1_0ie;
    jmi_int_t i1_0in;
    jmi_real_t i2_1i;
    jmi_int_t i2_1ie;
    jmi_int_t i2_1in;
    if (y_a == NULL) {
        JMI_ARRAY_INIT_1(STACK, R_0_r, R_0_ra, y_an, 2, 1, 2)
        JMI_ARRAY_INIT_1(STACK, jmi_real_t, jmi_array_t, tmp_1, 1, 1, 1)
        jmi_array_rec_1(y_an, 1)->x = tmp_1;
        JMI_ARRAY_INIT_1(STACK, jmi_real_t, jmi_array_t, tmp_2, 1, 1, 1)
        jmi_array_rec_1(y_an, 2)->x = tmp_2;
        y_a = y_an;
    }
    JMI_ARRAY_INIT_1(STACK, R_0_r, R_0_ra, temp_1_a, 2, 1, 2)
    *jmi_array_rec_1(temp_1_a, 1) = *JMI_GLOBAL(CCodeGenCompositeStatementTests_RecordStmt2_f_c);
    *jmi_array_rec_1(temp_1_a, 2) = *r_v;
    i1_0in = 0;
    i1_0ie = floor((2) - (1));
    for (i1_0i = 1; i1_0in <= i1_0ie; i1_0i = 1 + (++i1_0in)) {
        i2_1in = 0;
        i2_1ie = floor((1) - (1));
        for (i2_1i = 1; i2_1in <= i2_1ie; i2_1i = 1 + (++i2_1in)) {
            jmi_array_ref_1(jmi_array_rec_1(y_a, i1_0i)->x, i2_1i) = jmi_array_val_1(jmi_array_rec_1(temp_1_a, i1_0i)->x, i2_1i);
        }
    }
    JMI_DYNAMIC_FREE()
    return;
}
")})));
    end RecordStmt2;

end CCodeGenCompositeStatementTests;
