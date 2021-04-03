function validarn(e){
    var teclado=(document.all)?e.keyCode:e.which
    if(teclado==8)return true;

    var patron= /[0-9\d .]/

    var prueba= String.fromCharCode(teclado);
    return patron.test(prueba)
}

function operar(){
    var n1=document.formulario.cal1.value;
    var n2=document.formulario.cal2.value;

    var n11=parseInt(n1);
    var n21=parseInt(n2);
    if (n11==n21){
        var ope=n11*n21;
    }
    if (n11>n21){
        var ope=n11-n21;
    }
    if (n11<n21){
        var ope=n11+n21;
    }


    document.formulario.calti.value =ope;

}

function borrar(){
    document.formulario.cal1.value = "";
    document.formulario.cal2.value = "";
    document.formulario.calti.value = "";
}