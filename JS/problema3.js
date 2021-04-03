function validarn(e){
    var teclado=(document.all)?e.keyCode:e.which
    if(teclado==8)return true;

    var patron= /[0-9\d .]/

    var prueba= String.fromCharCode(teclado);
    return patron.test(prueba)
}

function descuento(){
    var valor=document.formulario.cantidad.value;
    var result=parseInt(valor);
    var descuento=result*.15;
    var total=result-descuento;

    document.formulario.sueldoti.value="$"+total;

}
function borrar(){
    document.formulario.cantidad.value = "";
    document.formulario.sueldoti.value = "";
}