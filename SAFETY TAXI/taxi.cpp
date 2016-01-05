// <![CDATA[
function taxi_price(num,mymin,myprice)
{
if ((num.value.length ==0 || num.value ==0)&&(mymin.value.length == 0 || mymin.value == 0))
	{	
		myprice.value = 0;		
		return;
	}
var d = num.value;
var price = 0;
if (d <= 1) price = 35;
	else if  (d <=10) 	price = 35 + (d-1)*5.5;
	else if (d <=20) 	price =	84.5 + (d-10)*6.5;
	else if (d <=40) 	price = 149.5 + (d-20)*7.5;
	else if (d <=60) 	price = 299.5 + (d-40)*8.0;
	else if (d <=80) 	price = 459.5 + (d-60)*9.0;
	else 				price = 639.5 + (d-80)*10.5;
price = Math.round(price);
if (price%2 == 0) price+=1;

var m = mymin.value;
var timecharge = m*2;
price = price + Math.floor(m*2/2)*2;

myprice.value = price;
}
// ]]>