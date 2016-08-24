// JavaScript Document
/* 字符串前后空格去除 */
function trim(str){
	str= str.replace(/^\s+/g,""); //去前空格
	str= str.replace(/\s+$/g,""); //去后空格
	return str;
}