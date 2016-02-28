//import java.lang.reflect.Array;
//import java.util.ArrayList;
//
//public class Parking {
//
//	
//	CHECK mogelijke nodes (verkleint het aantal mogelijkheden al )
//	for every track do;
//	for every train do:
//		check possible binnenkomst (links of rechts);
//		check possible departure: (links of rechts):
//	Zet dit allemaal in een lijst zodat je per trein per track een overzicht hebt of die LL, RR, RL of LR is. 
//	maak hier een array van, per track, per trein krijg je dan: 0 1 1 0 bijvoobeeld (RR, RL mogelijk).
//	end first part
//	
//	Set all trains in order of arrival time
//	for every track
//	Start building path list:
//		for node 1 update pathlist (all possible paths to node 1)
//		all posible options in a seperate ArrayList. 
//		2 
//		3 
//		5 
//		(in this case)
//		for de volgende train check: 
//
//			
//			Loop over alle huidige paden (in dit geval 3):
//				Elk pad moet nog een array hebben van 2 posities die de minimale tijd aangeeft dat een trein links
//				of rechts de track verlaat, als dit kleiner is dan de arrival time van de nieuwe trein dan zet je deze tijd op oneindig
//				Trein is dan namelijk weg en gebruikte tracklengte corrigeer je dan. 
//				
//				Elk pad moet nog een array hebben met de huidige bezette posities (RR, RL, LL, LR, in de vorm van de departure times).
//				Als LL of RL bezet is, kan LR niet meer, RR wel
//				Als RR of LR bezit is, kan RL niet meer, LL wel
//				
//				
//				check naar welke nodes van de volgende je allemaal kan (algemeen)
//				check per arc of dit ook echt een mogelijkheid is:
//					- lengte (als die kleiner is dan de tracklength)
//					_ Departure tijd (check of je m er voor kan plaatsen)
//					- Crossings. 
//				Als mogelijk is voeg dan toe aan deze ArrayList.
//				bijvoorbeeld nu:
//					2 - 4
//					2 - 3
//					3 - 1
//					5 -5
//					2- 5
//					3 -5
//					Herhaal deze laatste stap voor elke trein.
//
//			
//	
//
//}
