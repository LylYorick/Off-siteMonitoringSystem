/*
 * 取得农历信息
 */
function getLunarInfo() {
	var LunarInfo;
	var CalendarData=new Array(20);
	var madd=new Array(12);
	var TheDate=new Date();
	var tgString="甲乙丙丁戊己庚辛壬癸";
	var dzString="子丑寅卯辰巳午未申酉戌亥";
	var numString="一二三四五六七八九十";
	var monString="正二三四五六七八九十冬腊";
	var weekString="日一二三四五六";
	var sx="鼠牛虎兔龙蛇马羊猴鸡狗猪";
	var cYear,cMonth,cDay,cHour;
	var cDateString;
	var DateString;
	
	function init()
	{ 
	  CalendarData[0]=0x41A95;CalendarData[1]=0xD4A;CalendarData[2]=0xDA5;CalendarData[3]=0x20B55;
	  CalendarData[4]=0x56A;CalendarData[5]=0x7155B;CalendarData[6]=0x25D;CalendarData[7]=0x92D;
	  CalendarData[8]=0x5192B;CalendarData[9]=0xA95;CalendarData[10]=0xB4A;CalendarData[11]=0x416AA;
	  CalendarData[12]=0xAD5;CalendarData[13]=0x90AB5;CalendarData[14]=0x4BA;CalendarData[15]=0xA5B;
	  CalendarData[16]=0x60A57;CalendarData[17]=0x52B;CalendarData[18]=0xA93;CalendarData[19]=0x40E95;  // 2001-2020年
	  /*
	  0xA4B,0x5164B,0x6A5,0x6D4,0x415B5,0x2B6,0x957,0x2092F, 0x497,0x60C96,   // 1921-1930
	  0xD4A,0xEA5,0x50DA9,0x5AD,0x2B6,0x3126E, 0x92E,0x7192D,0xC95,0xD4A,     // 1931-1940
	  0x61B4A,0xB55,0x56A,0x4155B, 0x25D,0x92D,0x2192B,0xA95,0x71695,0x6CA,   // 1941-1950
	  0xB55,0x50AB5,0x4DA,0xA5B,0x30A57,0x52B,0x8152A,0xE95,0x6AA,0x615AA,    // 1951-1960
	  0xAB5,0x4B6,0x414AE,0xA57,0x526,0x31D26,0xD95,0x70B55, 0x56A,0x96D,     // 1961-1970
	  0x5095D,0x4AD,0xA4D,0x41A4D,0xD25,0x81AA5, 0xB54,0xB6A,0x612DA,0x95B,   // 1971-1980
	  0x49B,0x41497,0xA4B,0xA164B, 0x6A5,0x6D4,0x615B4,0xAB6,0x957,0x5092F,   // 1981-1990
	  0x497,0x64B, 0x30D4A,0xEA5,0x80D65,0x5AC,0xAB6,0x5126D,0x92E,0xC96,     // 1991-2000 0x41A95,0xD4A,0xDA5,0x20B55,0x56A,0x7155B,0x25D,0x92D, 0x5192B,0xA95,   // 2001-2010
	  0xB4A,0x416AA,0xAD5,0x90AB5,0x4BA,0xA5B, 0x60A57,0x52B,0xA93,0x40E95,   // 2011-2020
	  */
	  madd[0]=0;madd[1]=31;madd[2]=59;madd[3]=90;
	  madd[4]=120;madd[5]=151;madd[6]=181;madd[7]=212;
	  madd[8]=243;madd[9]=273;madd[10]=304;madd[11]=334;
	}
	function GetBit(m,n) {  return (m>>n)&1; }
	function e2c()
	{  
	  var total,m,n,k;
	  var isEnd=false;
	  var tmp=TheDate.getYear();
	  if (tmp<1900)  tmp+=1900;
	  total=(tmp-2001)*365
	    +Math.floor((tmp-2001)/4)
	    +madd[TheDate.getMonth()]
	    +TheDate.getDate()
	    -23;
	  if (TheDate.getYear()%4==0&&TheDate.getMonth()>1)
	    total++;
	  for(m=0;;m++)
	  {  
	    k=(CalendarData[m]<0xfff)?11:12;
	    for(n=k;n>=0;n--)
	    {
	      if(total<=29+GetBit(CalendarData[m],n))
	      { 
	        isEnd=true;
	        break;
	      }
	      total=total-29-GetBit(CalendarData[m],n);
	    }
	    if(isEnd)break;
	  }
	  cYear=2001 + m;
	  cMonth=k-n+1;
	  cDay=total;
	  if(k==12)
	  {
	    if(cMonth==Math.floor(CalendarData[m]/0x10000)+1)
	      cMonth=1-cMonth;
	    if(cMonth>Math.floor(CalendarData[m]/0x10000)+1)
	      cMonth--;
	  }
	  cHour=Math.floor((TheDate.getHours()+3)/2);
	}
	
	function GetcDateString()
	{ var tmp="";
	  tmp+=tgString.charAt((cYear-4)%10);   //年干
	  tmp+=dzString.charAt((cYear-4)%12);   //年支
	  tmp+="(";
	  tmp+=sx.charAt((cYear-4)%12);
	  tmp+=")年 ";
	  if(cMonth<1)
	  { 
	    tmp+="闰";
	    tmp+=monString.charAt(-cMonth-1);
	  }
	  else
	    tmp+=monString.charAt(cMonth-1);
	  tmp+="月";
	  tmp+=(cDay<11)?"初":((cDay<20)?"十":((cDay<30)?"廿":"卅"));
	  if(cDay%10!=0||cDay==10)
	    tmp+=numString.charAt((cDay-1)%10);
	  // if(cHour==13)tmp+="夜";
	  //   tmp+=dzString.charAt((cHour-1)%12);
	  // tmp+="时";
	  cDateString=tmp;
	  return tmp;
	}
	
	function GetDateString()
	{ 
	  var tmp="";
	  var t1=TheDate.getYear();
	  if (t1<1900)  t1+=1900;
	    tmp+=t1
	       +"年"
	       +(TheDate.getMonth()+1)+"月"
	       +TheDate.getDate()+"号"
	       //+TheDate.getHours()+":"
	       //+((TheDate.getMinutes()<10)?"0":"")
	       //+TheDate.getMinutes()
	       +"  星期"+weekString.charAt(TheDate.getDay()); 
	  DateString=tmp;
	  return tmp;
	}
	init();
	e2c();
	GetDateString();
	GetcDateString();
	LunarInfo = DateString+"&nbsp;"+cDateString;//

	return LunarInfo;
}