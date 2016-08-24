// JavaScript Document
function changeBg(str){
	if(str == "../images/bg2.gif"){
		str = "url(" + str + ")";
		document.body.style.backgroundImage = str;
		document.body.style.backgroundRepeat = "repeat";
	}else{
		str = "url(" + str + ")";
		document.body.style.backgroundImage = "";
		document.body.style.backgroundRepeat = "repeat-x";
		document.body.style.backgroundColor = "#C1E6F5";
	}
}