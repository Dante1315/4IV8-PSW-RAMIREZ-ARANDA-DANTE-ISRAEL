function validarn(e){
    var teclado=(document.all)?e.keyCode:e.which
    if(teclado==8)return true;

    var patron= /[0-9\d .]/

    var prueba= String.fromCharCode(teclado);
    return patron.test(prueba)
}

function calificacion(){
    var valor=document.formulario.cal1.value;
    var valo=document.formulario.cal2.value;
    var val=document.formulario.cal3.value;
    var exx=document.formulario.exa.value;
    var pf=document.formulario.pro.value;
    var result=parseInt(valor);
    var resul=parseInt(valo);
    var resu=parseInt(val);
    var pff=parseInt(pf)
    var ex=parseInt(exx)
    var prom=[(result+resul+resu)/3]*5.5;
    var ce=(ex*3);
    var cpr=(pff*1.5);
    var cf=cpr+prom+ce;

    document.formulario.calti.value=cf;

}
function borrar(){
    document.formulario.cal1.value = "";
    document.formulario.cal2.value = "";
    document.formulario.cal3.value = "";
    document.formulario.exa.value = "";
    document.formulario.pro.value = "";
    document.formulario.calti.value = "";

}