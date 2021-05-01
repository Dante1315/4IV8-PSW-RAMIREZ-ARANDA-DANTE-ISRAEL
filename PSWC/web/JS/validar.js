//Validar solo numeros
function validarn(e){
    var teclado = (document.all)?e.keyCode:e.which;
    if(teclado == 8)return true;

    var patron = /[0-9\d .]/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

//Validar solo palabras y espcacions

function validarp(e){
    var teclado = (document.all)?e.keyCode:e.which;
    if(teclado == 8)return true;

    var patron = /^[a-zA-Z ]*$/;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function validarc(e){
    var teclado = (document.all)?e.keyCode:e.which;
    if(teclado == 8)return true;

//Habria que copiar el correo de otra parte, 
//pero asi es seguro que no escribiran cualquier cosa XD

    var patron = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;

    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}