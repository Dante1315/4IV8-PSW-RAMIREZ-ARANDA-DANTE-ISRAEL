function validar{formulario}{

    /*validar que se escriban 5 caracteres */
    if(formulario.nombre.value.length <5){
        alert("Por favor escribe mas de 5 caracteres en el nombre")
        formulario.nombre.focus();

     return false;   
    }    
}