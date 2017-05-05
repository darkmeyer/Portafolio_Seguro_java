CREATE OR REPLACE FUNCTION F_BUSCAR_TALLER_RUT(rut VARCHAR2) RETURN VARCHAR2
IS
v_vrut VARCHAR2(10) := rut;
v_vidTaller VARCHAR2(5);
v_vnull VARCHAR2(5) := '-1';
BEGIN
  SELECT T.ID_TALLER INTO v_vidTaller FROM TALLER T
  JOIN EMPLEADO EM
  ON(T.EMPLEADO_ID_EMPLEADO = EM.ID_EMPLEADO)
  WHERE RUT = v_vrut;
    
  RETURN v_vidTaller; 
  
  EXCEPTION WHEN OTHERS THEN
    RETURN v_vnull;
END;

CREATE OR REPLACE FUNCTION F_INSERT_GRUA(
    rut              VARCHAR2,
    nombre           VARCHAR2,
    apellido         VARCHAR2,
    fono             VARCHAR2,
    direccion        VARCHAR2,
    ciudad           NUMBER) RETURN VARCHAR2
  IS
    v_vidgrua GRUA.ID_GRUA%TYPE;
    v_vrut    GRUA.RUT%TYPE := rut;
    v_vnombre GRUA.NOMBRE%TYPE := nombre;
    v_vapellido GRUA.APELLIDO%TYPE := apellido;
    v_vfono GRUA.FONO%TYPE := fono;
    v_vdireccion GRUA.DIRECCION%TYPE := direccion;
    v_nciudad GRUA.CIUDAD_ID_CIUDAD%TYPE := ciudad;
    mensaje VARCHAR2(150);
    cantidad NUMBER(5);
  BEGIN
      select count(*) INTO cantidad from GRUA;
      v_vidgrua := cantidad + 1;
      
      select count(*) INTO cantidad from GRUA where RUT = v_vrut;
      IF cantidad > 0 THEN     
         mensaje := 'Grua ya existe';        
      ELSE
        select count(*) INTO cantidad from GRUA where ID_GRUA = v_vidgrua;
        IF cantidad > 0 THEN
          mensaje := 'ID ya existe';
        ELSE
          INSERT INTO GRUA VALUES(v_vidgrua,v_vrut,v_vnombre,v_vapellido,v_vfono,v_vdireccion,v_nciudad);  
          mensaje := 'Grua Ingresado con exito ID Generada:' || v_vidgrua;
        END IF;
      END IF;  
    
    RETURN mensaje;
    
    EXCEPTION WHEN DUP_VAL_ON_INDEX THEN
      RETURN 'Grua ya existe ';
    WHEN OTHERS THEN
      RETURN 'Error al intentar Insertar Grua';
END;


CREATE OR REPLACE FUNCTION F_INSERT_TALLER(
    nombre           VARCHAR2,
    fono             VARCHAR2,
    direccion        VARCHAR2,
    CIUDAD_id_ciudad	NUMBER,
    EMPLEADO_id_empleado	VARCHAR2)RETURN VARCHAR2
  IS
    v_vidtaller TALLER.ID_TALLER%TYPE;
    v_vnombre TALLER.NOMBRE%TYPE := nombre;
    v_vfono TALLER.FONO%TYPE := fono;
    v_vdireccion TALLER.DIRECCION%TYPE := direccion;
    v_nidciudad TALLER.CIUDAD_ID_CIUDAD%TYPE := CIUDAD_id_ciudad;
    v_vidempleado TALLER.EMPLEADO_ID_EMPLEADO%TYPE := EMPLEADO_id_empleado;
    mensaje VARCHAR2(150);
    cantidad NUMBER(5);
  BEGIN
      select count(*) INTO cantidad from TALLER;
      v_nidmensaje := cantidad + 1;
      v_vidtaller := TO_CHAR(v_nidmensaje) || 't';
      
      select count(*) INTO cantidad from TALLER where NOMBRE = v_vnombre;
      IF cantidad > 0 THEN     
         mensaje := 'Taller ya existe';        
      ELSE
        select count(*) INTO cantidad from TALLER where ID_TALLER = v_vidtaller;
        IF cantidad > 0 THEN
          mensaje := 'ID ya existe';
        ELSE
          INSERT INTO TALLER VALUES(v_vidtaller, v_vnombre, v_vfono, v_vdireccion, v_nidciudad, v_vidempleado);  
          mensaje := 'Taller Ingresado con exito ID Generada:' || v_nidmensaje;
        END IF;
      END IF;  
    
    RETURN mensaje;
    
    EXCEPTION WHEN DUP_VAL_ON_INDEX THEN
      RETURN 'Taller ya existe ';
    WHEN OTHERS THEN
      RETURN 'Error al intentar Insertar Taller';
END;

CREATE OR REPLACE FUNCTION F_INSERT_EMPLEADO(    
    rut              VARCHAR2,
    pass             VARCHAR2,
    nombres          VARCHAR2,
    apellidos        VARCHAR2,
    correo           VARCHAR2,
    fono             VARCHAR2,
    fecha_nacimiento VARCHAR2,
    direccion        VARCHAR2,
    id_ciudad        NUMBER,
    id_cargo            NUMBER) RETURN VARCHAR2
  IS
    v_vrut EMPLEADO.RUT%TYPE := rut;
    v_vpass EMPLEADO.PASS%TYPE := pass;
    v_vnombres EMPLEADO.NOMBRES%TYPE := nombres;
    v_vapellidos EMPLEADO.APELLIDOS%TYPE := apellidos;
    v_vcorreo EMPLEADO.CORREO%TYPE := correo;
    v_vfono EMPLEADO.FONO%TYPE := fono;
    v_vfecha EMPLEADO.FECHA_NACIMIENTO%TYPE := fecha_nacimiento;
    v_vdire EMPLEADO.DIRECCION%TYPE := direccion;
    v_vidCiudad EMPLEADO.CIUDAD_ID_CIUDAD%TYPE := id_ciudad;
    v_ncargo EMPLEADO.CARGO_ID_CARGO%TYPE := id_cargo;
    cantidad NUMBER(4);
    mensaje VARCHAR2(150);
    v_vId EMPLEADO.ID_EMPLEADO%TYPE;
    v_nidmensaje NUMBER;
  BEGIN
      select count(*) INTO cantidad from EMPLEADO;
      v_nidmensaje := cantidad + 1;
      v_vId := TO_CHAR(v_nidmensaje) || 'e';
      
      select count(*) INTO cantidad from EMPLEADO where RUT = v_vrut;
      IF cantidad > 0 THEN     
         mensaje := 'Empleado ya existe';        
      ELSE
        select count(*) INTO cantidad from EMPLEADO where ID_EMPLEADO = v_vId;
        IF cantidad > 0 THEN
          mensaje := 'ID ya existe';
        ELSE
          INSERT INTO EMPLEADO VALUES(v_vId, v_vrut, v_vpass, v_vnombres, v_vapellidos, v_vcorreo, v_vfono, v_vfecha, v_vdire, v_vidCiudad, v_ncargo);  
          mensaje := 'Empleado Ingresado con exito ID Generada:' || v_nidmensaje;
        END IF;
      END IF;  
    
    RETURN mensaje;
    
    EXCEPTION WHEN DUP_VAL_ON_INDEX THEN
      RETURN 'Rut Empleado ya existe ';
    WHEN OTHERS THEN
      RETURN 'Error al intentar Insertar Empleado';
END;

CREATE OR REPLACE FUNCTION F_INSERT_REGION(id_region NUMBER, nombre VARCHAR2) RETURN VARCHAR2
  IS
    v_nIdRegion REGION.ID_REGION%TYPE := id_region;
    v_vnombre REGION.NOMBRE%TYPE := nombre;
    cantidad NUMBER(4);
    mensaje VARCHAR2(30);
  BEGIN
    select count(*) INTO cantidad from region where ID_REGION = v_nIdRegion and NOMBRE = INITCAP(v_vnombre);
    IF cantidad > 0 THEN
      mensaje := 'Region ya existe';
    ELSE
      INSERT INTO REGION VALUES(v_nIdRegion, v_vnombre);
      mensaje := 'Region Ingresada con exito';
    END IF;     
    
    RETURN mensaje;
    
    EXCEPTION WHEN DUP_VAL_ON_INDEX THEN
      RETURN 'ID ya existe ';
    WHEN OTHERS THEN
      RETURN 'Error En la BD';
END;

CREATE OR REPLACE FUNCTION F_INSERT_CIUDAD(id_ciudad NUMBER, nombre VARCHAR2, id_region NUMBER) RETURN VARCHAR2
  IS
    v_nIdCiudad CIUDAD.ID_CIUDAD%TYPE := id_ciudad;
    v_nIdRegion REGION.ID_REGION%TYPE := id_region;
    v_vnombre CIUDAD.NOMBRE%TYPE := nombre;
    cantidad NUMBER(4);
    mensaje VARCHAR2(30);
  BEGIN
    select count(*) INTO cantidad from ciudad where NOMBRE = v_vnombre and REGION_ID_REGION = v_nIdRegion;
    IF cantidad > 0 THEN
      mensaje := 'Ciudad ya existe';
    ELSE
      INSERT INTO CIUDAD VALUES(v_nIdCiudad, v_vnombre, v_nIdRegion);
      mensaje := 'Ciudad Ingresada con exito';
    END IF;     
    
    RETURN mensaje;
    
    EXCEPTION WHEN DUP_VAL_ON_INDEX THEN
      RETURN 'ID ya existe ';
    WHEN OTHERS THEN
      RETURN 'Error En la BD';
END;

select count(*) from ciudad where NOMBRE = 'Pozo Almonte' and REGION_ID_REGION = 15;

CREATE OR REPLACE FUNCTION F_UPDATE_REGION(id_region NUMBER, nombre VARCHAR2) RETURN VARCHAR2
  IS
    v_vIdRegion REGION.ID_REGION%TYPE := id_region;
    v_vnombre REGION.NOMBRE%TYPE := nombre;
    cantidad NUMBER(4);
    mensaje VARCHAR2(30);
  BEGIN
    select count(*) INTO cantidad from region where ID_REGION = v_vIdRegion;
    IF cantidad > 0 THEN
      UPDATE REGION SET NOMBRE = v_vnombre WHERE ID_REGION = v_vIdRegion;
      mensaje := 'Region Updateada';
    ELSE
      mensaje := 'Region No Existe';
    END IF;     
    
    RETURN mensaje;
    
    EXCEPTION WHEN OTHERS THEN
      RETURN 'Error En la BD';
END;
  
