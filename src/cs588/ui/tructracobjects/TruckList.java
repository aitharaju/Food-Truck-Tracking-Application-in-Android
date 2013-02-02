package cs588.ui.tructracobjects;
import android.location.Location;
import cs588.ui.tructrac.Menu;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;



public class TruckList
{
private static TruckList instance=new TruckList();
public  List<Truck> trucklist=new LinkedList<Truck>();
List<Menus> menu;
List<Tweets> tweets;
List<Review> reviews;
Truck truck;
Menus menuobj;
Tweets tweetobj;
Review reviewobj;
double lat;
double lng;
String truckname;
String street;
String city;
String zipcode;
float rating;
String cuisine;
String phonenumber;
String state;
boolean status;
public static TruckList getInstance()
{
	return instance;
}

public TruckList()
{
	
/***************1.Calbi*******************************/
	reviews=new LinkedList<Review>();
	menu=new LinkedList<Menus>();
	tweets=new LinkedList<Tweets>();
	/*Menu Item*/
	
	menuobj=new Menus("Boba","10$");
	menu.add(menuobj);
	menuobj=new Menus("Tacos","2$");
	menu.add(menuobj);
	menuobj=new Menus("Burrito","5$");
	menu.add(menuobj);
	menuobj=new Menus("Quesidilla","4.99$");
	menu.add(menuobj);
	menuobj=new Menus("Nachos","10$");
	menu.add(menuobj);
	menuobj=new Menus("Burrito Bowl","5.99$");
	menu.add(menuobj);
	
	/*Tweets*/
	tweetobj=new Tweets("(Calbi)T5 Here @ The Hollywood Park Casino.!! 7pm- 12pm Get ready for the horse races & enjoy a warm pork Burrito! :) MmmMmm","1 hour ago");
	tweets.add(tweetobj);
	tweetobj=new Tweets("(Calbi) T5 Good Morning #calbifans. Join us at The School of Arch. from 11:30 - 4:00pm :)","8 hours ago");
	tweets.add(tweetobj);
	tweetobj=new Tweets("(Calbi) T5 Here at USC on Mc Clintock and Jefferson until 9:00pm . Come enjoy a delicious burrito :) Mmmm","1 day ago");
	tweets.add(tweetobj);
	tweetobj=new Tweets("(Calbi) T5 Here on Jefferson and Hoover Until 2:00pm #calbifans follow us to Jefferson & McClintock.. :) 3-9pm","17 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("[Calbi T5] Here in Sherman Oaks, outside Ralphs on Ventura Blvd and Hazeltine Ave. Here until 9:00pm","15 November");
	tweets.add(tweetobj);
	
	/*Review*/
	reviewobj=new Review(4,"There's something about taking your lunch break at 11:30a, meandering down 4 flights of stairs and cold, criss-crossing hallways until you emerge into the blindingly bright world below; feeling a warm bench against your back, slowly thawing out the bone-chill of the office AC that blasts a hole into your very soul, biting into a soft, warm burrito...something about all that makes me feel a little more kindly disposed to food trucks at UCLA. So this truck should probably technically get 3 stars for straight food quality.","Suraj");
	reviews.add(reviewobj);
	reviewobj=new Review(3,"At work we have a rotating selection of 15-20 food trucks total that stop by, around 2 per day. On the days that I don't pack a lunch and don't feel like walking too far to get food, then I'll see what my food truck options are. So far, there aren't any trucks that really fulfill my needs of vegan and delicious and all are generally slightly overpriced. Usually vegetarian options are cheaper since there's no expensive meat being used unless they are using expensive vegetables.","John");
	reviews.add(reviewobj);
	reviewobj=new Review(5,"Calbi's tofu quesadillas are simply, the most successful combination of fusion tastes that I've had for a very long time. Maybe it's their sauce (which is a mixture of salsa, but sweet an tangy masala like - concoction), or the texture of the tofu that blends miraculously into the cheese and the tortilla, or just their service. Regardless of whichever field, they have my vote of confidence in their tofu quesadilla. You cannot go wrong with that decision.","Bob");
	reviews.add(reviewobj);
	reviewobj=new Review(1,"After spending a good amount of try at an art exhibition and trying to understand art,our exhausted brain cells needed some energy,and  all of us walked up to the Calbi truck and we ordered cheese quesdillas-which was 10 layers of cheese and light bread and had no flavor.It would have really made sense if they called it cheese plate!They had a very confusing menu filled with awkward combos,and sadly we benchmarked Calbi with the kind of food trucks-KOGI!!! Calbi lost..DUH...Will not go here,and shall not encourage anyone to go here when they are sober.","Jim");
	reviews.add(reviewobj);
	reviewobj=new Review(4,"The beef burrito was about $8.  The flavor of the meat was alright.  It was sweet.  The veggies were good too, but there was just something missing.  The burrito felt like something I'd make if I had leftover ingredients.  I don't know what was missing, but there was something wrong.  :/  Also, it was really wet.  ","Aditya");
	reviews.add(reviewobj);
	
	truckname="calbibbq";
	rating=(float) 5;
	street="1055 West Jefferson Blvd";
	city="Los Angeles";
	zipcode="90007";
	phonenumber="4082429729";
	cuisine="Mexican";
	lng=-118.288186;
	lat=34.025899;
	state="CA";
	truck=new Truck(menu,reviews,tweets,lat,lng,street,city,state,zipcode,truckname,cuisine,rating,phonenumber,true);
    trucklist.add(truck);
//    reviews.clear();
//    tweets.clear();
//    menu.clear();
    /***************2.Komodo*******************************/
	reviews=new LinkedList<Review>();
	menu=new LinkedList<Menus>();
	tweets=new LinkedList<Tweets>();
	/*Menu Item*/
	
	menuobj=new Menus("Komodo 2.0","8$");
	menu.add(menuobj);
	menuobj=new Menus("Asian Marinated Chicken","5$");
	menu.add(menuobj);
	menuobj=new Menus("Garlic or Truffle Fries","5$");
	menu.add(menuobj);
	menuobj=new Menus("Meatballs w/ Romesco Sauce","5$");
	menu.add(menuobj);
	menuobj=new Menus("Tacos","3$");
	menu.add(menuobj);
	menuobj=new Menus("Burritos","8$");
	menu.add(menuobj);
	
	/*Tweets*/
	tweetobj=new Tweets("(komodofood) Why we love the Middle http://komodofood.com/blog/fun/we-are-obsessed-with-the-middle/ http://fb.me/Ecv3Yw8d","1 hour ago");
	tweets.add(tweetobj);
	tweetobj=new Tweets("(komodofood) For all of you LA gourmands, one of our fave blogs- check it out and 'like it' on facebook :) http://fb.me/VKc1juL6","19 hours ago");
	tweets.add(tweetobj);
	tweetobj=new Tweets("(komodofood) Here at Encino Elementary watching Cars 2! 16941 Addison St. w/@COOLHAUS","21 hours ago");
	tweets.add(tweetobj);
	tweetobj=new Tweets("(komodofood) Highland Park! We're in town @ Sycamore Park (4702 N Figueroa St, Los Angeles) (11-3:30pm) We love The area, everyone show so much love :)","19 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("(komodofood) Help spread the word please. #sycamore grove park is great. #playground #picnic area and #food #truc http://tl.gd/e8t0j7 via @truckitfest","18 November");
	tweets.add(tweetobj);
	
	/*Review*/
	reviewobj=new Review(4,"We first tried Komodo quite some time ago and it has always been one of our favorites. If I had written this review after trying them the first tine they would have get 5 stars. And while I still love their tacos and the meatballs, the very limited menu here does get old. That's not to say that they aren't good, We just like to see some variety or perhaps some daily specials. The tacos and burritos here are top notch. We like the 2.0, the fish and grape, the blazing shrimp and the pork. Are these folks worth a try, absolutely! They did make it to our original top 10 list.","H and N");
	reviews.add(reviewobj);
	reviewobj=new Review(5,"my friend took me here on weds night, the truck is parked at the REI parking lot. SOOOO glad she took me because the tacos are freaken good!!! Had the komodo 2.0 and the fish and grapes, both were so goooood. Komodo 2.0 gives you meat and the corn on top just makes it tastier, and the fish and grapes gives you a healthy feel.. it probably isnt though since it had a lot of mayo but i loved it! Also had to try the truffle fries... add siracha! it makes everything that much better :) Oh and the service is amazing, great people!!! Might just wanna go there EVERY weds :)","Christine");
	reviews.add(reviewobj);
	reviewobj=new Review(4,"Really enjoyed their shrimp taco (spicy) & truffle fries... I liked how it had some Indonesian flair and a classy look to their truck. Nice to know food trucks can gather enough buzz to open a brick and mortar location. I hope this company continues to grow!","Scott");
	reviews.add(reviewobj);
	reviewobj=new Review(3,"Attended the Komodo Truck in West La. I ordered the combo which included, 2 tacos, a side and a drink. I chose the Shrimp Tacos and I was told it is spicy. When I am told that, it usually means it is medium.  OMG!! This shrimp was SO SPICY my mouth was on fire.  I love spicy but this was too much. It was served on two itty bitty small corn tacos which were semi dry.  The truffle fries were DELICIOUS. I really wanted to like this place but I don't think that paying $10 for the above was reasonable.","Efi");
	reviews.add(reviewobj);
	reviewobj=new Review(5,"I LOVE fries so it was a given I would like this place. They have really good 'Truffle' fries and the food was good as well.  One of the better trucks circling the LA area!","Alicia");
	reviews.add(reviewobj);
	
	truckname="komodofood";
	rating=(float) 3.5;
	street="8809 West Pico Blvd";
	city="Los Angeles";
	zipcode="90034";
	phonenumber="3102465153";
	cuisine="Mexican";
	lat=34.0549924;
	lng=-118.3840677;
	state="CA";
	truck=new Truck(menu,reviews,tweets,lat,lng,street,city,state,zipcode,truckname,cuisine,rating,phonenumber,true);
    trucklist.add(truck);
//    reviews.clear();
//    tweets.clear();
//    menu.clear();
    /***************3.Glowfish*******************************/
	reviews=new LinkedList<Review>();
	menu=new LinkedList<Menus>();
	tweets=new LinkedList<Tweets>();
	/*Menu Item*/
	
	menuobj=new Menus("Veggie Okonomiyaki","5$");
	menu.add(menuobj);
	menuobj=new Menus("Chicken Okonomiyaki","8$");
	menu.add(menuobj);
	menuobj=new Menus("Beef Okonomiyaki","8$");
	menu.add(menuobj);
	menuobj=new Menus("Lobster Okonomiyaki","7$");
	menu.add(menuobj);
	menuobj=new Menus("Tofu Okonomiyaki","5$");
	menu.add(menuobj);
	menuobj=new Menus("Salmon Okonomiyaki","7$");
	menu.add(menuobj);
	
	/*Tweets*/
	tweetobj=new Tweets("(glowfish) Help us find out how americans feel about #okonomiyaki @glowfishtruck by filling out our survey! http://www.surveymonkey.com/s/2JBC7SW","6 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("(glowfish) Sorry everybody. We have had some major mechanical malfunctions this morning and will not be on the road today or tomorrow.","3 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("(glowfish) Lunch today at CBS Radford in Studio City on Ventura and Radford. 12p-2p.","2 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("(glowfish) New weekly schedule up, see you this week!","1 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("(glowfish) Dinner tonight in Granada hills. Chats worth and white oak. Glowing til 9p.","28 October");
	tweets.add(tweetobj);
	
	/*Review*/
	reviewobj=new Review(5,"OMG my okonomiyaki was amazing. I ordered the shrimp and bacon okonomiyaki with bonito flakes on top. This tasted just like the okonomiyaki I had when I lived in Japan for a few months. The portions are huge, the sauce and mayo combo is yummy and the people working the truck were really nice. I will be visiting this truck often to have more okonomiyaki and to try the other dishes as well.","Portia");
	reviews.add(reviewobj);
	reviewobj=new Review(5,"Unbelievable food! We sampled several items and shared. Try the beef +garlic soy or the salmon okonomiyaki!  You won't be disappointed.","Dona");
	reviews.add(reviewobj);
	reviewobj=new Review(5,"Wow. For truck vendor food,  this is as good as it gets. I got the lobster okonomiyaki is excellent. The lobster is fresh and delivered in huge chunks. The names of the dishes make ordering a little intimidating, but once you try it, you will be an immediate fan. Wow, this is street food at its best.","William");
	reviews.add(reviewobj);
	reviewobj=new Review(5,"Glowfish is my favorite food truck in LA! The food is fresh, the service is friendly, and the salmon is easily the best I have ever tasted (from a truck!! I know!!). Generous portions of healthy (if you choose) and delicious food with innovative menu items served up in recyclable trays. You cannot lose with Glowfish!","Kat");
	reviews.add(reviewobj);
	reviewobj=new Review(5,"I have so far been a bit underwhelmed with food trucks until I tried Glowfish, this one's a keeper. I had the okonomiyaki which was totally delicious, I'll definitely be following these guys around LA.","Hannah");
	reviews.add(reviewobj);
	
	truckname="glowfishfoodtruck";
	rating=(float) 5;
	street="924 West Washington";
	city="Los Angeles";
	zipcode="90015";
	phonenumber="3107210260";
	cuisine="Japanese";
	lat=34.0371281;
	lng=-118.2781073;
	state="CA";
	truck=new Truck(menu,reviews,tweets,lat,lng,street,city,state,zipcode,truckname,cuisine,rating,phonenumber,true);
    trucklist.add(truck);
//    reviews.clear();
//    tweets.clear();
//    menu.clear();

    /***************4.Armando's Lunch Truck*******************************/
	reviews=new LinkedList<Review>();
	menu=new LinkedList<Menus>();
	tweets=new LinkedList<Tweets>();
	/*Menu Item*/
	
	menuobj=new Menus("Sausage breakfast burrito","5$");
	menu.add(menuobj);
	menuobj=new Menus("Veggie Burger","3$");
	menu.add(menuobj);
	menuobj=new Menus("Spicy Chicken Sandwich","4.75$");
	menu.add(menuobj);
	menuobj=new Menus("Malibu Chicken Sandwich","5$");
	menu.add(menuobj);
	menuobj=new Menus("Albondigas","3$");
	menu.add(menuobj);
	menuobj=new Menus("Summer Burrito","4.5$");
	menu.add(menuobj);
	
	/*Tweets*/
	/*Cannot find on twitter */
	tweetobj=new Tweets("Tomorrow: lunch at 31st and ocean park","14 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Highland park! We are here at Platform for artwalk! 5027 York Blvd. Till midnight","12 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("TONIGHT!!!! At Tiki No Bar 4657 Lankershim 5-9pm","10 Nov");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Still cooking at the LAX Food Truck Lot today! 5998 W 98th St, 11a-2p","8 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Get your lunch on at the crowne plaza hotel at 5998 W 98th St, 11a-2p","8 November");
	tweets.add(tweetobj);
	
	/*Review*/
	reviewobj=new Review(4,"WHaaa??? I can't believe I never wrote a review for this place...blasphemy! This is the best hidden secret at USC. Everything they have is delicious and cheap! I always get the lendale. It's basically a sandwich filled with eggs, bacon, hash browns, cheese, and even jelly if you want. It sounds weird at first, but its absolutely amazing.","Chantelle");
	reviews.add(reviewobj);
	reviewobj=new Review(4,"Mmm great truck! I got the spicy chicken sandwich because Armando said it was the most popular item. The sandwich was great!! The portion was very generous and came with thick avocado slices inside. The sandwich was 5 dollars and was worth the money.","Tiffany");
	reviews.add(reviewobj);
	reviewobj=new Review(2,"Really people, its not that great. I don't get the hype at all. NY pastrami was like pouring salt in my mouth. The carne asada burrito had bizarre cuts of beef in it, that had to  be spit out. And the sandwiches don't taste that great to be honest.","Chillin");
	reviews.add(reviewobj);
	reviewobj=new Review(5,"The original USC food truck, and still my favorite, Armando's is tasty across the board and really cheap too. To top it off the people are by far the nicest you'll find anywhere near this campus. A real gem.","Justin");
	reviews.add(reviewobj);
	reviewobj=new Review(5,"A staple for any Trojan on main campus. Armando is very friendly, the food tastes great (especially the breakfast burritos), and the prices are suprisingly low. They also accept credit cards, very convenient.","Stephen");
	reviews.add(reviewobj);
	
	truckname="armandos";
	rating=(float) 4.5;
	street="3470 McClintock Ave";
	city="Los Angeles";
	zipcode="90089";
	phonenumber="";
	cuisine="Mexican";
	lat=34.0237167;
	lng=-118.2879466;
	state="CA";
	truck=new Truck(menu,reviews,tweets,lat,lng,street,city,state,zipcode,truckname,cuisine,rating,phonenumber,false);
    trucklist.add(truck);
//    reviews.clear();
//    tweets.clear();
//    menu.clear();

    /***************5.La Taquiza*******************************/
	reviews=new LinkedList<Review>();
	menu=new LinkedList<Menus>();
	tweets=new LinkedList<Tweets>();
	/*Menu Item*/
	
	menuobj=new Menus("Shrimp Quezadilla","6.99$");
	menu.add(menuobj);
	menuobj=new Menus("Fish Quezadilla","6.5$");
	menu.add(menuobj);
	menuobj=new Menus("Shrimp Nachos","7.99$");
	menu.add(menuobj);
	menuobj=new Menus("Meat Nachos","6.99$");
	menu.add(menuobj);
	menuobj=new Menus("Fish Burrito","7.5$");
	menu.add(menuobj);
	menuobj=new Menus("Shrimp Burrito","7.99$");
	menu.add(menuobj);
	
	/*Tweets*/
	tweetobj=new Tweets("saludos","30 June");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Hanging out at Washington and overland with @rebelbite for lunch till 2p!","17 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Catch us for lunch today at westside food truck central at Washington and overland! 1130-2","17 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Hey guys! We are at palms and sepulveda for dinner till 9p!","15 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Lunch today at 31st and ocean park at the Santa Monica business park! 11a-2p dinner at palms and sepulveda","15 November");
	tweets.add(tweetobj);
	
	/*Review*/
	reviewobj=new Review(5,"As a USC grad, La Taquiza has become a home away from home, and I have to get some of its goodness any time I am near campus! Always loved the wet burrito and nachos, but now lovin the Korean BBQ, too!","Ryan");
	reviews.add(reviewobj);
	reviewobj=new Review(3,"Prices a bit steep for the look of this place. Customer service is nice. Food is pretty good","Erik");
	reviews.add(reviewobj);
	reviewobj=new Review(4,"Although the plain tacos were not that interesting, and in fact a bit below average, I am still in afterglow (days later!) regarding the shrimp tacos and al pastor mulita. Hands down, some of the best I've had in LA!!!! What a great find, can't wait to go back! Will say that the sandia agua fresca was a twee overly-sweet, but quaffable","Charla");
	reviews.add(reviewobj);
	reviewobj=new Review(5,"Great Mexican food at a great price and lots to choose from and made fast. Nothing not to like here, other than maybe the locale.","Dustin");
	reviews.add(reviewobj);
	reviewobj=new Review(5,"Can never get enough multitask & their new black bean & corn salad is healthy & flavorful.  This USC tradition has my vote as best taqueria in California!  Fight on!","Christine");
	reviews.add(reviewobj);
	
	truckname="lataquiza";
	rating=(float) 4;
	street="3009 S Figueroa Street";
	city="Los Angeles";
	zipcode="90007";
	phonenumber="2137419795";
	cuisine="Mexican";
	lat=34.0250014;
	lng=-118.2780542;
	state="CA";
	truck=new Truck(menu,reviews,tweets,lat,lng,street,city,state,zipcode,truckname,cuisine,rating,phonenumber,false);
    trucklist.add(truck);
//    reviews.clear();
//    tweets.clear();
//    menu.clear();
	
    /***************6.No Tomatoes*******************************/
	reviews=new LinkedList<Review>();
	menu=new LinkedList<Menus>();
	tweets=new LinkedList<Tweets>();
	/*Menu Item*/
	
	menuobj=new Menus("Potato Kathi Roll","6$");
	menu.add(menuobj);
	menuobj=new Menus("Seekh Dog","7$");
	menu.add(menuobj);
	menuobj=new Menus("Paneer Kathi Roll","7$");
	menu.add(menuobj);
	menuobj=new Menus("Charlie Chaplin Chicken Burger","7$");
	menu.add(menuobj);
	menuobj=new Menus("Paneer Samosa","2$");
	menu.add(menuobj);
	menuobj=new Menus("Mango Lassi","2$");
	menu.add(menuobj);
	
	/*Tweets*/
	tweetobj=new Tweets("Currently Reading http://notomatoestruck.com/","16 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("SantaAnita Food Truck festival today! Get your Seekh Dog and find out new entrees being launched at the No Tomatoes Cafe!","5 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("@foodiechronicle Thx for the awesome review. We are figuring out a way to improve the chicken being dry (main issue using only white meat)","28 October");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Hey El Segundo! Come eat with us @ElSegundoDDaGG @LeMansbodyshop; @lomoarigato, @NoJodasKitchen, @wafflesdeliege. 200 Nevada Street.","19 October");
	tweets.add(tweetobj);
	tweetobj=new Tweets("In El Segundo 2nite? Then come to @ElSegundoDDaGG at 200 Nevada Street. @NoJodasKitchen, @CheeseballWagon. 6:00pm.","19 October");
	tweets.add(tweetobj);
	
	/*Review*/
	reviewobj=new Review(3,"I liked the Chapli burger, cause it seemed unique, and I love Indian flavors.  I would get it again which is saying something when these trucks offer a lot of competition. Prices were on the high side, but so is much of food truck fare.","Robert");
	reviews.add(reviewobj);
	reviewobj=new Review(2,"Ordered: Paneer Kathi Roll ($7) Saddest Kathi roll of my life.  Weak on the Paneer, no vibrant flavors, roll was like a flavorless sheet of plywood.","EK");
	reviews.add(reviewobj);
	reviewobj=new Review(4,"Tried this for the first time today.  The Seehk Dog was yummy, pungent, tasty.  Definite yummies!","Mommy");
	reviews.add(reviewobj);
	reviewobj=new Review(4,"Yummy! I had the biryani a couple weeks ago and I am definitely in need of a fix! I got this with a jelly donut float from Lake Street Creamery's truck and maybe I'm weird but I felt they complemented each other. Very  yummy.","Kk J");
	reviews.add(reviewobj);
	reviewobj=new Review(5,"I had the chapli burger and the biryani today. Both great in taste. The chapli burger has a slight crunch to the chicken patty. Its just great. Cant wait to eat there again.","Venkatesh");
	reviews.add(reviewobj);
	
	truckname="notomatoes";
	rating=(float) 3;
	street="8516 West 3rd Street";
	city="Los Angeles";
	zipcode="90048";
	phonenumber="3102891133";
	cuisine="Indian";
	lat=34.0734190;
	lng=-118.3770664;
	state="CA";
	truck=new Truck(menu,reviews,tweets,lat,lng,street,city,state,zipcode,truckname,cuisine,rating,phonenumber,true);
    trucklist.add(truck);
//    reviews.clear();
//    tweets.clear();
//    menu.clear();		
    /***************7.KrazyBBQ*******************************/
	reviews=new LinkedList<Review>();
	menu=new LinkedList<Menus>();
	tweets=new LinkedList<Tweets>();
	/*Menu Item*/
	
	menuobj=new Menus("Krazy Burrito","7$");
	menu.add(menuobj);
	menuobj=new Menus("Krazy Taco","2.5$");
	menu.add(menuobj);
	menuobj=new Menus("Krazy Dog","6$");
	menu.add(menuobj);
	menuobj=new Menus("Krazy Plate","8$");
	menu.add(menuobj);
	menuobj=new Menus("Krazy Sandwich","7$");
	menu.add(menuobj);
	menuobj=new Menus("Krazy Fries","3$");
	menu.add(menuobj);
	
	/*Tweets*/
	tweetobj=new Tweets("21850 oxnard st. Woodland hills. Warner center Marriott 11am to 5pm!!! 10 other gournment food truck!!","19 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Krazybbq on Granada hills!! 17824 chatworth. Granada hills!! Until 10 00 pm","18 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Krazybbq serving lunch at 4550 maywood ave Vernon 90058 Until 2 30pm","18 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("krazybbq now serving dinner at los feliz with 3 other gournment food. 1728 vermont ave until 9pm","17 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Krazybbq will serve dinner at 1728 Vermont ave la 90027 5pm to 9pm!","17 November");
	tweets.add(tweetobj);
	
	/*Review*/
	reviewobj=new Review(5,"First time having this was pretty amazing.  I wasnt expecting great but it wasn't bad...They were posted on chatsworth and zelzah every friday along with the other food trucks. Decided to try it just because, . Tried the Taco prime rib steak, and ended up buying a Fat burrito (just a bigger version of it) to go. It was yuuummmmy!  Apparently there's a lot of kbbq trucks that night but I highly recommend this as one of the best ones out there.","Christine");
	reviews.add(reviewobj);
	reviewobj=new Review(4,"This truck is really under-rated. I enjoy the Asian-Mexican fusion of the Bullkogi Burritos. I haven't tried anything else, but these burritos are delish. U have to remember to add extra cheese cus they get a little skimpy but the beef and rice (which used to b fries) combo paired with the cabbage is amazing.","Jenelle");
	reviews.add(reviewobj);
	reviewobj=new Review(4,"Good stuff, burrito was packed and well put together. Taste was filled with many flavors and especially the beef. I liked they had a good a amount of veggies and beef. They originally forgot my order (it was really busy) but they offered me a free drink with my order which was a nice gesture. Something I really appreciated, other trucks would just apologize and get you your order and nothing more.","Mark");
	reviews.add(reviewobj);
	reviewobj=new Review(1,"Dissappointed. What I got was not what I ordered. Got my money back, though. This truck was invited to my employer today to provide a special lunch day. I ordered the taquitos which sounded awsome....Beef, KB Avocado and KB Salsa, cabbage, cheddar cheese, cilantro, tomato. What I got was overfried beef taquitos (so brown the tortillas were about copper in color) with shredded cabbage on top sprinkled with some hot sauce.","Sandi");
	reviews.add(reviewobj);
	reviewobj=new Review(2,"I had the short rib beef taco. I literally just tried a beef taco from 'The Yummy One' truck (also Korean-Mexican Fusion), so I had high hopes for this place. But unfortunately, the beef marination was way too sweet for my taste. So, unfortunately, between the two Korean-Mexican Fusion food trucks, I am going to lean towards 'The Yummy One' food truck.","Angela");
	reviews.add(reviewobj);
	
	truckname="krazybbq";
	rating=(float) 2.5;
	street="4925 Wilshire Blvd";
	city="Los Angeles";
	zipcode="90010";
	phonenumber="3107109547";
	cuisine="Korean";
	lat=34.0621231;
	lng=-118.3382854;
	state="CA";
	truck=new Truck(menu,reviews,tweets,lat,lng,street,city,state,zipcode,truckname,cuisine,rating,phonenumber,true);
    trucklist.add(truck);
//    reviews.clear();
//    tweets.clear();
//    menu.clear();
    /***************8.Tacos El Unico*******************************/
	reviews=new LinkedList<Review>();
	menu=new LinkedList<Menus>();
	tweets=new LinkedList<Tweets>();
	/*Menu Item*/
	
	menuobj=new Menus("Fish Taco","2.49$");
	menu.add(menuobj);
	menuobj=new Menus("Wet Burrito","5.99$");
	menu.add(menuobj);
	menuobj=new Menus("Veggie Burrito","3.50$");
	menu.add(menuobj);
	menuobj=new Menus("Street Taco","0.99$");
	menu.add(menuobj);
	menuobj=new Menus("Quesadilla","2.75$");
	menu.add(menuobj);
	menuobj=new Menus("Enchiladas","4.99$");
	menu.add(menuobj);
	
	/*Tweets*/
	tweetobj=new Tweets("New 'Bell Special' Jr. Mexican Burger, Fries and a 22 oz. bev. Only $3.99 + tx. Exclusively at our Bell location http://pic.twitter.com/O4FkIYG5","18 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Got some color on the walls now, at our South Gate location http://pic.twitter.com/3LvnEGul","17 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("South Gate's remodel almost done! http://fb.me/DPK2byWt","15 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Maybe we should bring back combos that look like this. http://fb.me/NpkIyJ5Y","14 October");
	tweets.add(tweetobj);
	tweetobj=new Tweets("La Raza has just arrived at out South Gate location, come join us for prizes and specials 2 for 1 on Burritos http://yfrog.com/o0up7ydfkj","9 October");
	tweets.add(tweetobj);
	
	/*Review*/
	reviewobj=new Review(4,"Yum! But it's super spicy! Worth it. The carne asada is really good!!! So is the CHURRO, even though its 1.00 instead of 0.75 now","Elite");
	reviews.add(reviewobj);
	reviewobj=new Review(3,"Four Tacos and a 22 oz drink sounds great but the drive home turned them into soggy messes. The Quesadillas are the best I've ever had though, hot and crisp (even after the drive home) and with generous fillings of cheese and meat. Oh and they got horchata :D","Howard");
	reviews.add(reviewobj);
	reviewobj=new Review(3,"Four tacos and a 22 oz drink for five dollars?  Take that 5 dollar footlongs at Subway! The carne asada tacos are in the upper 50% of tacos consumed in la la land.  For cheap food prices around USC, you can't go wrong really.","Samantha");
	reviews.add(reviewobj);
	reviewobj=new Review(4,"Discovered this randomly. Surprisingly good tacos, especially the fish tacos. Great for a late night snack or hungover food. For $5, you get 4 tacos and a large drink. Pretty good deal, but the boys typically order 2 of these per person to be full. The horchata here's pretty good too.","Julia");
	reviews.add(reviewobj);
	reviewobj=new Review(5,"There's one thing I don't get about tacos el unico! All there locations but the one by U.S.C. suck. I've eaten at 3 other locations and it's just no the same. But my review is for tacos el unico on Vermont and this location is awesome. Try there Mexican hamburger! It's basically a humburger with taco meat inplace of a humburger party and it is awesome. The person who created that Is a real American hero.","Frank");
	reviews.add(reviewobj);
	
	truckname="tacoselunico";
	rating=(float) 3;
	street="2524 S Vermont Ave";
	city="Los Angeles";
	zipcode="90007";
	phonenumber="3237371044";
	cuisine="Mexican";
	lat=34.032961;
	lng=-118.2914029;
	state="CA";
	truck=new Truck(menu,reviews,tweets,lat,lng,street,city,state,zipcode,truckname,cuisine,rating,phonenumber,true);
    trucklist.add(truck);

    /***************9. Grill Em All *******************************/
	reviews=new LinkedList<Review>();
	menu=new LinkedList<Menus>();
	tweets=new LinkedList<Tweets>();
	/*Menu Item*/
	
	menuobj=new Menus("Hannah Montana","4.99$");
	menu.add(menuobj);
	menuobj=new Menus("Behemoth","6.99$");
	menu.add(menuobj);
	menuobj=new Menus("Pomme frites","4.00$");
	menu.add(menuobj);
	menuobj=new Menus("Samoa Joe","2.99$");
	menu.add(menuobj);
	menuobj=new Menus("Blue Cheer","3.75$");
	menu.add(menuobj);
	menuobj=new Menus("Waste ‘Em all ","4.99$");
	menu.add(menuobj);
	
	/*Tweets*/
	tweetobj=new Tweets("Where's the spot to be at TONIGHT?!?@YukonFoodFest! That's WHERE! us w/ @lobstatruck @BSweetMobile (cont) http://tl.gd/e8okpn","18 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Don't forget that Grill Em All caters your office/parties/events/weird other stuff! Perfect for the holidays, right? Email us for info.","18 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Southbay we are coming to you tonight for @SouthBayDDaGG at 6pm 24300 Western Ave Harbor City Let's crush burgs & tots & fies! #BurgerParty","17 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Hey Studio City/NoHo/Universal City: Lunch today is at Lankershim & Valleyheart at Weddington park! Open around noon! #crushthemenu","17 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("One hour away from dinner in the OC! 88 Fair Drive at the @ocfair for OC Food Truck Fare! Open around 5:30/6pm! Costa Mesa...let's party!","16 November");
	tweets.add(tweetobj);
	
	/*Review*/
	reviewobj=new Review(4,"Had to try the infamous Behemoth burger. Grilled cheese sandwiches for buns, bacon, bbq sauce, onions, pickles (which i picked out), and a nice juicy burger! It was delicious!","Karen");
	reviews.add(reviewobj);
	reviewobj=new Review(3,"Size doesn't equal quality. Big burgers, delicious buns, but the flavoring of the burgers themselves lack. They need pepper, salt and some pizazz. None of the burgers have pop. Over hyped, over hyped, over hyped. I'd only get this as I walk out of a concert starving, but I'd never go out of my way for it.","Brad");
	reviews.add(reviewobj);
	reviewobj=new Review(5,"The witti burger was so delicious. The meat so tender and juicy, I have to go back and try the other things on there menu. ","Francis");
	reviews.add(reviewobj);
	reviewobj=new Review(4,"I am in LOVE with one of their creations called the Dee Snider. The combination of Meat, Bacon w/ jelly & peanut butter is just great to me. It is salty & sweet and i Love the combination. ","Sal");
	reviews.add(reviewobj);
	reviewobj=new Review(5,"Hands Down the Best Burger I've ever had The Witte (pr. Wit-e)cream cheese, deep fried bacon, beer/ Sriracha onion, malt vinegar aioli.OUTSTANDING!","Robert");
	reviews.add(reviewobj);
	
	truckname="grillemall";
	rating=(float) 4;
	street="817 West 34th";
	city="Los Angeles";
	zipcode="90089";
	phonenumber="3232525603";
	cuisine="American";
	lat=34.0232410;
	lng=-118.2841810;
	state="CA";
	truck=new Truck(menu,reviews,tweets,lat,lng,street,city,state,zipcode,truckname,cuisine,rating,phonenumber,true);
    trucklist.add(truck);
    /***************10. Curbside Cravings *******************************/
	reviews=new LinkedList<Review>();
	menu=new LinkedList<Menus>();
	tweets=new LinkedList<Tweets>();
	/*Menu Item*/
	
	menuobj=new Menus("Teriyaki BBQ","5.99$");
	menu.add(menuobj);
	menuobj=new Menus("Tocino Burger","6.99$");
	menu.add(menuobj);
	menuobj=new Menus("Crispy Dinguan","4.87$");
	menu.add(menuobj);
	menuobj=new Menus("Daing Fish Balls","5.99$");
	menu.add(menuobj);
	menuobj=new Menus("Crispy Lechon Kawali ","3.99$");
	menu.add(menuobj);
	menuobj=new Menus("Tapsilog","4.99$");
	menu.add(menuobj);
	
	/*Tweets*/
	tweetobj=new Tweets("@curbsidecraving in Koreatown today until 3pm see you there !","16 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Doors up in @Koreatown 3600 Wilshire Blvd bet Harvard & Kingsley until 3pm ...lobster balls, tocino burgers and other fave grubs!","16 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("@curbsidecraving will be in Northridge , on Devonshire and Reseda tonight 6-9pm !","15 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Doors up until 3pm in 3600 blk of Wilshire Blvd between Kingsley & Harvard and see you tonight in Glendale at the..http://fb.me/1h7Pu2pOR","15 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("@curbsidecraving will be in Eagle Rock tonight 5-9 pm on Eagle Rock blvd and Verdugo in front of Salon Expo , come... fb.me/O7JPXKTL","10 November");
	tweets.add(tweetobj);
	
	/*Review*/
	reviewobj=new Review(5,"I would totally make the effort to find this food truck the next time I am in LA. The prices are decent and the food is great. Even my mom had to agree that this Filipino food was legit.","Mel");
	reviews.add(reviewobj);
	reviewobj=new Review(2,"this review is about their catering service.there was a big rush and an immediate, ridiculous long line.  Essentially, unless I was willing to stand in line in the sun for at least 30 more minutes, my extra $10 was totally wasted.","Daniel");
	reviews.add(reviewobj);
	reviewobj=new Review(5,"Very good food, I really recommend the Tocino Burger, it's like a big variety of tastes in one burger. Even the bread is tasty!  ","Joseph");
	reviews.add(reviewobj);
	reviewobj=new Review(4,"That little morsel of goodness is their lobster balls. Little chunks of lobster impaled on a toothpick.... YUM!!!","H and N");
	reviews.add(reviewobj);
	reviewobj=new Review(5,"Hands Down the Best Burger I've ever had The Witte (pr. Wit-e)cream cheese, deep fried bacon, beer/ Sriracha onion, malt vinegar aioli.OUTSTANDING!","Robert");
	reviews.add(reviewobj);
	
	truckname="curbsidecravings";
	rating=(float) 3;
	street="534 S. Occidental Bl";
	city="Los Angeles";
	zipcode="90057";
	phonenumber="8186530877";
	cuisine="Filipino";
	lat=34.0651619;
	lng=-118.2838065;
	state="CA";
	truck=new Truck(menu,reviews,tweets,lat,lng,street,city,state,zipcode,truckname,cuisine,rating,phonenumber,true);
    trucklist.add(truck);

    /***************12. Vizzi Truck *******************************/
	reviews=new LinkedList<Review>();
	menu=new LinkedList<Menus>();
	tweets=new LinkedList<Tweets>();
	/*Menu Item*/
	
	menuobj=new Menus("White Truffle Popcorn","2.50$");
	menu.add(menuobj);
	menuobj=new Menus("Venison Burger","3.75$");
	menu.add(menuobj);
	menuobj=new Menus("Mushroom & Onion Grilled Cheese","5.50$");
	menu.add(menuobj);
	menuobj=new Menus("Angel Hair Pasta","5.75$");
	menu.add(menuobj);
	menuobj=new Menus("chun li taco or piadina","5.50$");
	menu.add(menuobj);
	
	/*Tweets*/
	tweetobj=new Tweets("2nite at @thebrigvenice dinner. be there. come hungry. eat. 5:30-??","18 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("@StudioDNA 4 dinner 2nite 5:30-:8:30 in SaMo.","17 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Trucks: @VizziTruck & @BoolBBQ expected in the UCLA Court of Sciences for lunch today. http://bit.ly/b4uFvQ","17 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Salt roasted local beets, saffron 'yolk', sea bean, apple granita @ Savoy Restaurant / Bar At The Hanford http://instagr.am/p/Uf3JC/","16 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("TONIGHT! We will be @taftfoodtrucks in Woodland Hills 5:30-9pm w/ @ButtermilkTruck @the_yummy_one @VizziTruck @CantersTruck","16 November");
	tweets.add(tweetobj);
	
	/*Review*/
	reviewobj=new Review(5,"Vizzi Truck is one of those food trucks where it exceeded my expectations in terms of food and ambiance.","Jerryleen");
	reviews.add(reviewobj);
	reviewobj=new Review(4,"vizzi truck's menu is filled with fancier choices like pasta, risotta, sweet breads, seafood, etc. check them out!","Lin Lin S");
	reviews.add(reviewobj);
	reviewobj=new Review(4,"Really cool gourmet food truck! I mean veal sweetbreads from a food truck! That's a whole level of awesome.","Nathan");
	reviews.add(reviewobj);
	reviewobj=new Review(5,"The Vizzi Food Truck is awesome! Yes, it is a bit expensive, but the quality is superior and worth a splurge now and then.  Love the TV!","Christina");
	reviews.add(reviewobj);
	reviewobj=new Review(3,"Had this a while back. No complaints as far as the food. The wait was simply not worth the reward. But doubt the lines are like that these days","Jonathan");
	reviews.add(reviewobj);
	
	truckname="vizzi";
	rating=(float) 4;
	street="12312 W. Olympic Blvd.";
	city="Los Angeles";
	zipcode="90064";
	phonenumber="3238636589";
	cuisine="Asian";
	lat=34.0313440;
	lng=-118.4567170;
	state="CA";
	truck=new Truck(menu,reviews,tweets,lat,lng,street,city,state,zipcode,truckname,cuisine,rating,phonenumber,true);
    trucklist.add(truck);
    /***************13. Ta Bom Truck *******************************/
	reviews=new LinkedList<Review>();
	menu=new LinkedList<Menus>();
	tweets=new LinkedList<Tweets>();
	/*Menu Item*/
	
	menuobj=new Menus("Top Sirloin Steak","2.50$");
	menu.add(menuobj);
	menuobj=new Menus("Chicken Burrito","8.00$");
	menu.add(menuobj);
	menuobj=new Menus("Chorizo","2.50$");
	menu.add(menuobj);
	menuobj=new Menus("Ground Beef","5.00$");
	menu.add(menuobj);
	menuobj=new Menus("Giselle Wrap","8.00$");
	menu.add(menuobj);
	
	/*Tweets*/
	tweetobj=new Tweets("THANKSGIVING is upon us ? you can have Brazilian food at your dinner table this year :) Want coxinhas,... http://t.co/8RCuzuuv","21 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Happy Monday!! LUNCH today in Santa Monica ~ 12pm - 2pm 31st Street & Ocean Park Blvd, Santa Monica, CA 90405 Hope... http://t.co/WByE8fiw","21 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("WASHINGTON & OVERLAND for Lunch!! Doors open now until 2pm!! :)","18 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("LUNCH TIME!! Pennsylvania & 26th!! :) doors open from 12pm to 2pm!!","17 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("DINNER in Granada Hills!! FOOD TRUCK FRENZY! 6pm to 9pm 10453 Louise Ave Granada Hills CA 91344","16 November");
	tweets.add(tweetobj);
	
	/*Review*/
	reviewobj=new Review(5,"I visited this truck when it was in Culver City (Overland/Washington) and I was not disappointed. I ordered two asada tacos and they were amazing. ","Kelly");
	reviews.add(reviewobj);
	reviewobj=new Review(4,"Chorizo tacos (3 stars) - bold flavors naturally come easy from the grounded chorizo meat, but what's up with using only one thin tortilla? It fell apart within seconds of picking up. It is the ultimate street taco faux pas -- gotta do the double lining of the tortilla.","Dru C");
	reviews.add(reviewobj);
	reviewobj=new Review(5,"I say the Food Network should've nominated them for the food truck competition they currently have! But for next one, you got my vote Ta Bom!","Carla");
	reviews.add(reviewobj);
	reviewobj=new Review(2,"OVER-RATED.The food was OK, but not worth the price!","Joe G");
	reviews.add(reviewobj);
	reviewobj=new Review(3,"Ta Bom has awesome Brazilian food to go!","Jerryleen");
	reviews.add(reviewobj);
	
	truckname="tabom";
	rating=(float) 3;
	street="31st Street & Ocean Park, Santa Monica";
	city="Los Angeles";
	zipcode="90405";
	phonenumber="2135008078";
	cuisine="Brazillian";
	lat=34.0111019;
	lng=-119.6045728;
	state="CA";
	truck=new Truck(menu,reviews,tweets,lat,lng,street,city,state,zipcode,truckname,cuisine,rating,phonenumber,true);
    trucklist.add(truck);

    /***************14. The Mighty Boba Truck *******************************/
	reviews=new LinkedList<Review>();
	menu=new LinkedList<Menus>();
	tweets=new LinkedList<Tweets>();
	/*Menu Item*/
	
	menuobj=new Menus("Boneless Pork Chop","4.50$");
	menu.add(menuobj);
	menuobj=new Menus("Taiwanese Sausage","5.00$");
	menu.add(menuobj);
	menuobj=new Menus("Spam Sliders","6.50$");
	menu.add(menuobj);
	menuobj=new Menus("Tofu Steak (Vegetarian)","5.50$");
	menu.add(menuobj);
	menuobj=new Menus("Curry Spud Balls","8.00$");
	menu.add(menuobj);
	
	/*Tweets*/
	tweetobj=new Tweets("New plan! TMBT is between 3rd and 2nd St on Arizona Ave. in SaMo by Third Street Promenade. Catch us while the sun's still shining!","19 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Change of plans! Heading out to SaMo Third St. Promenade now... Will update soon :)","19 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Morning! Beat the RAIN & get ur boba on in Woodland Hills 4 Rotary Arts/Crafts Fest @ Warner Ctr Park w/ @KingKoneLA @JoseOMalleys ++ 10-5pm","18 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("SURPRISE! We're out in SaMo for lunch again (truck is fixed, whew*) Find us on Ocean Park/31st 11-2:30pm and Get Your Boba On ^_^v","17 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("So SORRY fans! Truck has mechanical issues so entire day is cancelled :'( No @RHTruckFiesta 2nite but the other GFTs will still be there!","16 November");
	tweets.add(tweetobj);
	
	/*Review*/
	reviewobj=new Review(5,"Dude, these guys are great.  They are friendly and accommodating.  The food is among the best you will find on a food truck. ","Brian");
	reviews.add(reviewobj);
	reviewobj=new Review(3,"This truck satisfies my need for Downtown LA Boba, but if I am ever in SGV. I am sticking to my regular joint.","Karen N");
	reviews.add(reviewobj);
	reviewobj=new Review(3,"i'll give you one more shot mighty boba but after that.. i'll just suffer through my work day without you.","Selena");
	reviews.add(reviewobj);
	reviewobj=new Review(5,"It's like a mobile Taiwanese tea shop!!The crispy buttermilk chicken is so delicious!!  And when you ask for a spicy level of 7+, it really kicks in!","Talia");
	reviews.add(reviewobj);
	reviewobj=new Review(3,"A friend took me here. I was not going to try anything, but I saw they had mango grean tea. I went ahead and tried it.  Sweetness was just right! I am very picky when it comes to how sweet it should be.","Elisa");
	reviews.add(reviewobj);
	
	truckname="mightybobatruck";
	rating=(float) 3;
	street="5161 N. Lankershim Blvd.North Hollywood";
	city="Los Angeles";
	zipcode="90405";
	phonenumber="6266074832";
	cuisine="Taiwanese";
	lat=34.1645880;
	lng=-118.3749180;
	state="CA";
	truck=new Truck(menu,reviews,tweets,lat,lng,street,city,state,zipcode,truckname,cuisine,rating,phonenumber,true);
    trucklist.add(truck);

    /***************15. NaanStop *******************************/
	reviews=new LinkedList<Review>();
	menu=new LinkedList<Menus>();
	tweets=new LinkedList<Tweets>();
	/*Menu Item*/
	
	menuobj=new Menus("Tandoori Chicken","4.50$");
	menu.add(menuobj);
	menuobj=new Menus("Kabobs","5.00$");
	menu.add(menuobj);
	menuobj=new Menus("Tandoori Paneer","6.50$");
	menu.add(menuobj);
	menuobj=new Menus("Samosa","5.50$");
	menu.add(menuobj);
	menuobj=new Menus("Lamb Naanwich","8.00$");
	menu.add(menuobj);
	
	/*Tweets*/
	tweetobj=new Tweets("@MiracleMileLA its been too long. Comin your way for lunch today! Catch us at 5900 wilshire across from LACMA","18 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Free ice cream sammies tonight @COOLHAUS store! Grand opening! 8588 Washington Blvd 6-7p","17 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("2night! CerritosHS 530-830p 12500 183rd st @grlldcheesetruk @CrepesBonaparte @mytornadopotato @NaanStop @CalbiBBQ @letsrollittruck #Cerritos","17 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Hanging out at Washington and overland with @rebelbite for lunch till 2p!","17 November");
	tweets.add(tweetobj);
	tweetobj=new Tweets("Catch us for lunch today at westside food truck central at Washington and overland! 1130-2","17 November");
	tweets.add(tweetobj);
	
	/*Review*/
	reviewobj=new Review(5,"The food is delicious! My favorite is the chicken and lamb naanwich...wait, those are the only naanwiches I've had. ","Yeyen");
	reviews.add(reviewobj);
	reviewobj=new Review(5,"I absolutely love NaanStop's masala fries. At first glance they look like chili fries, but the smell and taste is all Indian.","Ruel");
	reviews.add(reviewobj);
	reviewobj=new Review(4,"I would love it if they had a version of the the traditional, but always delicious garlic naan as a simple snack option.","Lucy");
	reviews.add(reviewobj);
	reviewobj=new Review(3,"So very average. I was all set to heart this place. I LOVE Indian food. I mean real, deep, serious, long-term love. This place didn't do it for me. ","Jessica");
	reviews.add(reviewobj);
	reviewobj=new Review(5,"This food truck is soooo delicious! The paneerwich is my favorite, and is a must have.","Bij");
	reviews.add(reviewobj);
	
	truckname="naanstop";
	rating=(float) 3;
	street="Santa Monica 31st and Ocean Park ";
	city="Los Angeles";
	zipcode="90405";
	phonenumber="6266074832";
	cuisine="Indian";
	lat=34.0111019;
	lng=-119.6045728;
	state="CA";
	truck=new Truck(menu,reviews,tweets,lat,lng,street,city,state,zipcode,truckname,cuisine,rating,phonenumber,true);
    trucklist.add(truck);

//    reviews.clear();
//    tweets.clear();
//    menu.clear();

    
}

public List<Truck> getTruckDetails(String name, int type,double lat, double lng)
{
	List<Truck> temp=new LinkedList<Truck>();
	Truck temptruck;
	double tlat,tlng;
	int index=0;
	switch(type)
	{
	case 0:
	//Name
		for(int i=0;i<trucklist.size();i++)
		{
			temptruck=trucklist.get(i);
			if(temptruck.name.indexOf(name)!=-1)
			{
				tlat=temptruck.lat;
				tlng=temptruck.lng;
				temptruck.miles=roundTwoDecimals(distance(lat,lng,tlat,tlng));
				temp.add(trucklist.get(i));
			}
		}
		Collections.sort(temp,new sortbydistance());

		break;
	case 1:
	//Location
		for(int i=0;i<trucklist.size();i++)
		{
			temptruck=trucklist.get(i);
			if(temptruck.name.indexOf(name)!=-1)
			{
				tlat=temptruck.lat;
				tlng=temptruck.lng;
				temptruck.miles=roundTwoDecimals(distance(lat,lng,tlat,tlng));
				temp.add(trucklist.get(i));
			}
		}
		Collections.sort(temp,new sortbydistance());
		
		break;
	case 2:
		for(int i=0;i<trucklist.size();i++)
		{
			temptruck=trucklist.get(i);
			if(temptruck.cuisine.indexOf(name)!=-1)
			{
				tlat=temptruck.lat;
				tlng=temptruck.lng;
				temptruck.miles=roundTwoDecimals(distance(lat,lng,tlat,tlng));
				temp.add(trucklist.get(i));
			}
		}
		Collections.sort(temp,new sortbydistance());
		break;
		
	case 4:
		for(int i=0;i<trucklist.size();i++)
		{
			temptruck=trucklist.get(i);
			if(temptruck.name.indexOf(name)!=-1)
			{
				tlat=temptruck.lat;
				tlng=temptruck.lng;
				System.out.println(temptruck.name+getQuadrant(GlobalValues.lat,GlobalValues.lng,tlat,tlng));
				if(getQuadrantAugmented(lat)==getQuadrant(GlobalValues.lat,GlobalValues.lng,tlat,tlng))
				{
					temptruck.miles=roundTwoDecimals(distance(GlobalValues.lat,GlobalValues.lng,tlat,tlng));
					temp.add(trucklist.get(i));
				}
				
			}
			}
		
	Collections.sort(temp,new sortbydistance());

		break;
	}
	
	return temp;
	
}
public List<Truck> getTruckDetails(String name, int type,double lat, double lng,float degrees)
{
	List<Truck> temp=new LinkedList<Truck>();
	Truck temptruck;
	double tlat,tlng;
	int index=0;
	switch(type)
	{
	case 0:
	//Name
		for(int i=0;i<trucklist.size();i++)
		{
			temptruck=trucklist.get(i);
			if(temptruck.name.indexOf(name)!=-1)
			{
				tlat=temptruck.lat;
				tlng=temptruck.lng;
				temptruck.miles=roundTwoDecimals(distance(lat,lng,tlat,tlng));
				temp.add(trucklist.get(i));
			}
		}
		Collections.sort(temp,new sortbydistance());

		break;
	case 1:
	//Location
		break;
	case 2:
		break;
		
	case 4:
		for(int i=0;i<trucklist.size();i++)
		{
			temptruck=trucklist.get(i);
			if(temptruck.name.indexOf(name)!=-1)
			{
				tlat=temptruck.lat;
				tlng=temptruck.lng;
				if(getQuadrantAugmented(degrees)==(getQuadrant(GlobalValues.lat,GlobalValues.lng,tlat,tlng)))
				{				System.out.println(temptruck.name+getQuadrantAugmented(degrees));

					temptruck.miles=roundTwoDecimals(distance(GlobalValues.lat,GlobalValues.lng,tlat,tlng));
					temp.add(trucklist.get(i));
				}
				
			}
			}
		
	Collections.sort(temp,new sortbydistance());

		break;
	}
	
	return temp;
	
}
public class sortbydistance implements Comparator<Truck>
{

public int compare(Truck o1, Truck o2) 
{
	Double o1d=new Double(o1.miles);
	Double o2d=new Double(o2.miles);
	
		return o1d.compareTo(o2d);
	
	
}		
}
double roundTwoDecimals(double d) {
    DecimalFormat twoDForm = new DecimalFormat("#.##");
return Double.valueOf(twoDForm.format(d));
}
private double distance(double lat1, double lon1, double lat2, double lon2) {
	  double theta = lon1 - lon2;
	  double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
	  dist = Math.acos(dist);
	  dist = rad2deg(dist);
	  dist = dist * 60 * 1.1515;
	
	  return (dist);
	}
/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
/*::  This function converts decimal degrees to radians             :*/
/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
private double deg2rad(double deg) {
  return (deg * Math.PI / 180.0);
}

/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
/*::  This function converts radians to decimal degrees             :*/
/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
private double rad2deg(double rad) {
  return (rad * 180.0 / Math.PI);
}
public static float getAzimuth(Location site, Location sat) 
{
	
	double azimuth = 0.0;
    double beta = 0.0;
    double siteLat = Math.toRadians(site.getLatitude());
    double satLon = Math.toRadians(sat.getLongitude());
    double siteLon = Math.toRadians(site.getLongitude());

    // get the right spherical triangle beta angle
    // from the antenna to the sub-satellite spot
    beta = Math.tan(satLon - siteLon) / Math.sin(siteLat);

    // azimuth is the supplement of the beta angle
    if (Math.abs(beta) < Math.PI)
            azimuth = Math.PI - Math.atan(beta);
    else
            azimuth = Math.PI + Math.atan(beta);

    // back to degrees
    azimuth = Math.toDegrees(azimuth);

    // manage N/S hemispheres
    if (site.getLatitude() < 0.0)
            azimuth = azimuth - 180;
    if (azimuth < 0.0)
            azimuth = azimuth + 360;

    return (float) azimuth;
}

int getQuadrantAugmented(double lat2)
{
	if(lat2>=0&&lat2<=90)
		return 2;
	if(lat2>90&&lat2<=180)
		return 1;
	if(lat2>180&&lat2<=270)
		return 4;
	if(lat2>=-90&&lat2<0)
		return 3;
	return 0;
}
int getQuadrant(double lat1,double lng1,double lat2,double lng2)
{
	double x1=180+lng1;
	double y1=90-lat1;
	double x2=180+lng2;
	double y2=90-lat2;
	if((x2-x1)>0&&(y2-y1)>0)
		return 3;
	if((x2-x1)>0&&(y2-y1)<0)
		return 2;
	if((x2-x1)<0&&(y2-y1)<0)
		return 1;
	if((x2-x1)<0&&(y2-y1)>0)
		return 4;
	if((x2-x1)==0&&(y2<y1))
		return 1;
	if((x2-x1)==0&&(y2>y1))
		return 2;
 	if((y2-y1)==0&&(x2>x1))
		return 2;
 	if((y2-y1)==0&&(x2<x1))
		return 1;
	return 0;
}
double getAngle(double lat1,double lng1,double lat2,double lng2)
{
	double x1=180+lng1;
	double y1=90-lat1;
	double x2=180+lng2;
	double y2=90-lat2;
	double slope=(y2-y1)/(x2-x1);
	double degrees=Math.toDegrees(Math.atan(slope));
	
	return degrees;
}
}
