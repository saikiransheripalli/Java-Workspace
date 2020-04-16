import java.util.Random;
import java.util.Scanner;

public class Game {
	
	public String name(int i){
	String players;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter player"+(i+1)+" name : ");
		
		players = sc.next();
		return players;
	}
	
	
	public int choice(String playerName){
	int choice;
	Random rnd = new Random();
	choice = rnd.nextInt(3)+1;
	
		/*Scanner sc = new Scanner(System.in);
		System.out.print("\n1.ROCK\t2.PAPER\t3.SCISSOR\n"+playerName+" enter your Choice : ");
		choice = sc.nextInt();*/
	
		switch (choice){
		case 1:
			System.out.println("------"+playerName+" you picked Rock------\n");
			break;
		case 2:
			System.out.println("------"+playerName+" you picked paper------\n");
			break;
		case 3:
			System.out.println("------"+playerName+" you picked Scissor------\n");
			break;
			
		/*default:
			System.out.println("\n------"+playerName+" you picked wrong option------\n Please enter correct option \n-----------------------------");
			choice(playerName);*/
			
		}
		return choice;
	}
	
	
	public int compare(int choice1,int choice2){
		if(choice1==choice2) return 0;
		switch(choice1){
		case 1:  //1=Rock
			return(choice2 == 3 ? 1 : 0);//rock beats scissor
		case 2:  //2=Paper
			return(choice2 == 1 ? 1 : 0);//paper beats rock
		case 3:  //3=Scissor
			return(choice2 == 2 ? 1 : 0);//scissor beats paper
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		String player[] = new String[4];
		int choice[] = new int[4];
		int result[][] =new int[4][4];
		int finalresult[][] =new int[4][4];
		
		System.out.println("Welcome to RockPaperScissors Game !!\n"+"It's a four player's Game........\n");
		Game gameObj = new Game();

		for(int p=0;p<4;p++){
			player[p] = gameObj.name(p);
		}

		//BELOW STATEMENTS ARE TO VERIFY MYSELF......... WHETHER MY CODE IS RIGHT OR WRONG

		/*
		System.out.print("players list\n------------\n");
		for(int p=0;p<4;p++){
		System.out.print(player[p]+"\t"+choice[p]+"\n");
		}*/

		for(int repeat = 1 ; repeat <= 50; repeat++){
			
			for(int p=0;p<4;p++){
			choice[p] = gameObj.choice(player[p]);
			}
			
			for(int i = 0 ; i < 4 ; i++){
				for(int j = 0 ; j < 4 ; j++){
					result[i][j]  = gameObj.compare(choice[i], choice[j]);
					finalresult[i][j]+=result[i][j];
				}
			}

			System.out.println("\n---------------------------\nResult\n---------------------------");
			System.out.print("\n-------------------------------------------------\nplayer Against        |"+player[0]+"|\t|"+player[1]+"|\t|"+player[2]+"|\t|"+player[3]+"|\n-------------------------------------------------\n");

			for(int i = 0 ; i < 4 ; i++){
				System.out.print("player wins |"+player[i]+"\t\t");
				for(int j = 0 ; j < 4 ; j++){
					System.out.print(finalresult[i][j]+"\t");
				}
				System.out.println();
			}
		}
	}
}
	
	

