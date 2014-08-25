
package Parameter

model Enum
    type E = enumeration(A,B,C);
    parameter E e = E.A;
end Enum;

package Error

model Dependent
  parameter Real pri = 3;
  parameter Real prd = 2*pri;
  constant Real cr = 5;
  parameter Integer pii = 4;
  parameter Integer pid = 2*pii;
  constant Integer ci = 4;
  parameter Boolean pbi = true;
  parameter Boolean pbd = false and not pbi;
  constant Boolean cb = true;
end Dependent;

model Structural
    type E = enumeration(A,B,C);
    parameter Real          a = 3;
    parameter Integer       b = 3;
    parameter E             c = E.A;
    parameter Boolean       d = true;
    
    parameter Real dummy[n];
    parameter Integer n = if (d) then integer(a) + b else Integer(c);
end Structural;

end Error;

end Parameter;