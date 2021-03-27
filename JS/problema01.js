function validarn(e){
    var teclado=(document.all)?e.keyCode:e.which
    if(teclado==8)return true;

    var patron= /[0-9\d .]/

    var prueba= String.fromCharCode(teclado);
    return patron.test(prueba)
}

function interes(){
    var valor=document.formulario.cantidad.value;
    var result=parseInt(valor);
    var interes=result*.02;
    var total=result+interes;

    document.formulario.sueldoti.value="$"+total;

}