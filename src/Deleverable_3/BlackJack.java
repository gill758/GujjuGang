package Deleverable_3;

import java.util.Scanner;

public class BlackJack {
    
    public static void main(String args[]){
    
        //welcome messages
        System.out.println("Project By Gujju Gang");
        System.out.println("Welcome to BlackJack!");
        
        //creating a deck and shuffling the cards
        GroupOfCards playingDeck = new GroupOfCards();
        playingDeck.createFullDeck();
        playingDeck.shuffle();
        
        //creating player and dealer decks
        GroupOfCards playerDeck = new  GroupOfCards();
        GroupOfCards dealerDeck = new  GroupOfCards();
        
        //initial balance of user for betting
        double playerMoney = 100.0;
        
        String winnerLine = "";
        
        //to get user input
        Scanner userInput = new Scanner(System.in);
        
        //the game works until the user has enough balance
        while(playerMoney > 0){
            System.out.println("\nYour current balance: $" + playerMoney +
                    "\nHow much would you like to bet?");
            double playerBet = userInput.nextDouble();
            
            //if the user does not have enough balance
            if(playerBet > playerMoney){
                System.out.println("You don't have enough balance to bet $" +
                        playerBet);
                continue;
            }
            boolean endRound = false;
            
            //giving the player two cards
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);
            
            //giving the dealer two cards
            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);
            
            //game
            while(true){
                System.out.println("\nYour Hand :");
                System.out.println(playerDeck.toString());
                System.out.println("Total of your cards : "+playerDeck.cardValue());
                System.out.println("\nDealer's hand:\n" + dealerDeck.getCard(0).toString()+ 
                        " and [the other card Faced Down]");
                
                System.out.println("\nWould you like to Hit or Stand?");
                System.out.println("Enter 1 for Hit and 2 for Stand");
                String response = userInput.next();
                
                if(checkValue(response) == true)
                {
                    //doing a hit
                    if(response.equals("1")){
                        playerDeck.draw(playingDeck);
                        System.out.println("\nYou got a: " + playerDeck.getCard(playerDeck.deckSize()-1).toString());
                        if(playerDeck.cardValue()>21){
                            System.out.println("\nBust. Sum of your cards: " + playerDeck.cardValue());
                            winnerLine = "Dealer wins.";
                            playerMoney -= playerBet;
                            endRound = true;
                            break;
                        }
                    }
                    //doing a stand
                    if(response.equals("2")){
                        break;
                    }
                }
                else
                    System.out.println("Please enter only 1 or 2");
            }
            
            System.out.println("Dealer's Cards: " + dealerDeck.toString());
            
            //dealer's draws
            while((dealerDeck.cardValue() < 17) && endRound == false){
                dealerDeck.draw(playingDeck);
                System.out.println("Dealer Draws " + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
            }
            
            //if dealer wins
            if((dealerDeck.cardValue() > playerDeck.cardValue()) && endRound == false){
                System.out.println("Dealer Wins");
                winnerLine = "Dealer wins.";
                playerMoney -= playerBet;
                endRound = true;
            }
            
            //user wins - dealer busts
            System.out.println("Sum of dealer's cards : " +dealerDeck.cardValue());
            if((dealerDeck.cardValue() > 21) && endRound == false){
                System.out.println("Dealer Bust, You Win!!");
                winnerLine = "You win.";
                playerMoney += playerBet;
                endRound = true;
            }
            
            //if it's a tie
            if((playerDeck.cardValue()) == (dealerDeck.cardValue()) && endRound == false){
                System.out.println("It is a tie. None of you wins!");
                winnerLine = "None of you wins.";
                endRound = true;
            }
            
            //user wins - sum of cards greater
            if((playerDeck.cardValue()) > dealerDeck.cardValue() && endRound == false){
                System.out.println("You Win!!");
                winnerLine = "You win.";
                playerMoney += playerBet;
                endRound = true;
            }
            
            else if(endRound == false){
                playerMoney -= playerBet;
                endRound = true;
            }
            
            //put the cards back to the deck
            playerDeck.moveToDeck(playingDeck); 
            dealerDeck.moveToDeck(playingDeck);
            System.out.println("End of Round!");
            System.out.println(winnerLine);
        }
        System.out.println("Game over; You are out of money ");
        System.out.println("Thank you for playing!");
    }
    public static boolean checkValue(String res)
    {
        if(res.equals("1")||(res.equals("2"))){
            return true;
        }
        return false;
    }
}
