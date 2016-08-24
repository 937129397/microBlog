/**
*  1、添加三个下拉框标签<select id="year"></select>
                     <select id="month"></select>
					 <select id="date"></select>
*  2、填充年月日
		1）填充年   初始化Option对象                 var op = new Option(value,text);
		           添加到selectobj.options中       selectobj.options.add(op);
*				   将值默认为当前年份                selectobj.value = nyear;
*       2）填充月   初始化option对象                 var op = new Option(value,text);
		           添加到options中                  selectobj.options.add(op);
*                  将值默认为当前月份                selectobj.value = nmonth;
        3）填充日  1、 获得天数    根据不同月份获得天数：datecount
		                    1、3、5、7、8、10、12月          ：  31天
		                    4、6、9、11月                   ：  30天
							2月份    平年                   ：  29天
							        闰年                   ：  28天
		        初始化option对象   var op = new Option(value,text);
		        添加到options中   selectobj.options.add(op);
*				将值默认为当前年份  selectobj.value = ndate;
		4）级联   年份  ||   月份  修改-------日期更改
*
*
*
*/

	//加载函数
	/*window.onload = function (){
		//调用填充函数
		nowday();		
		var monthobj = document.getElementById("month");
		var yearobj =  document.getElementById("year");
		//当年、月修改时，日期作相应改变
		yearobj.onchange = changeday;
		monthobj.onchange = changeday;
		}*/
	 //填充年、月、日,默认时间为当前日期
	function nowday(){
		//1、获得当前日期
		var now = new Date();
		var nyear = now.getFullYear();
		var nmonth = now.getMonth()+1;//月份从0-11，用于界面显示时必须要做+1操作
		var ndate = now.getDate();
		
		
		//2、填充年份下拉菜单
		//---1、获得年份下拉菜单对象
		var yearobj = document.getElementById("year");
		//---2、填充年份下拉菜单   1970 - 2011
		var op;
		for(var y=nyear-50;y<=2011;y++){
			op = new Option(y,y);
			yearobj.options.add(op);			
			}
		//---3、将默认值设置为当前年份
		yearobj.value=nyear;
			
		//3、填充月份下拉菜单	
		//---1、获得月份下拉菜单对象
		var monthobj = document.getElementById("month");
		//---2、填充月份下拉菜单
		var op ;
		for(var m=1;m<=12;m++){
			op = new Option(m,m);
			monthobj.options.add(op);			
			}
		//---3、默认值设置为当前月份
		//monthobj.value = nmonth;
		monthobj.value = nmonth;   
		
		//4、填充日期下拉菜单
		//---1、获得日期下拉菜单对象
		var dateobj = document.getElementById("date");
		//---2、填充日期下拉菜单
		filldate(nyear,nmonth);
		//---3、将默认值设置为当前日期
		dateobj.value = ndate;	
		}
		
		//填充日期下拉菜单函数
		function filldate(year,month){
			//---1、初始化天数计数器，默认值设置为30
			var datecount = 30;
			var op;
			//---2、分别根据年、月重新设置天数
			//----2.1、如果是  1|3|5|7|8|10|12月      datecount = 31
			if(month ==1 ||month==3||month==5||month==7||month==8||month==10 ||month==12){
				datecount=31;
			}
			//----2.2、如果是   2月   再根据年份决定 ：平年  |  闰年
			else if(month==2){
				   //-----2.2.1  闰年判断条件： year能被400整出  或  year被4整除且不能被100整除  
					if(year%400==0||(year%100!=0 && year%4==0)){
						//闰年   29天
						datecount = 29;
						}else{	
					//-----2.2.2  否则为平年
						//平年   28天
							datecount = 28;
							}			
					}
			//3、填充日期下拉菜单
			//获得日期下拉框对象
			var dateobj = document.getElementById("date");
			for(var d=1;d<=datecount;d++){
				op = new Option(d,d);
				dateobj.options.add(op);
				}				
			}
	//级联函数
	function changeday(){
		//1、分别获得年、月下拉菜单选中值
		var yearvalue = document.getElementById("year").value;
		var monthvalue = document.getElementById("month").value;
		//2、获得日期下拉框对象
		var dateobj = document.getElementById("date");
		//补充！！！：当年月修改时，日期下拉菜单需要重置，需要清空对象
		dateobj.length = 0;
		//3、调用日期填充函数，填充下拉菜单
		filldate(yearvalue,monthvalue);
		//4、将默认值设为1
		dateobj.value = 1;
		}

