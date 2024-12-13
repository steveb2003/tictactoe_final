//package com.csc;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class tictactoe


{
    public static ArrayList<String> grid = new ArrayList<>();
    public static int counter = 0;
    public static boolean running_computer = true;
    public static boolean running_random_move = true;
    public static String input_char_1 = "";
    public static String input_char_2 ="";
    public static String game_mode ="";
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        grid.add("1");
        grid.add("|");
        grid.add("2");
        grid.add("|");
        grid.add("3");

        Collections.addAll(grid,"_", "_", "_", "_","_");

        grid.add("4");
        grid.add("|");
        grid.add("5");
        grid.add("|");
        grid.add("6");

        Collections.addAll(grid, "_", "_", "_", "_","_");

        grid.add("7");
        grid.add("|");
        grid.add("8");
        grid.add("|");
        grid.add("9");
        
        tictactoe_score();

        System.out.print("Please select the game mode you would like to play. Enter 'HvH' for Human vs. Human or 'HvC' for Human vs. Computer: ");
        game_mode = in.next();
        switch (game_mode)
        {
            case "HvH":
                System.out.print("Please enter a custom mark for Player 1: ");
                input_char_1= in.next();
                System.out.print("Please enter a custom mark for Player 2: ");
                input_char_2=in.next();
                if (input_char_1.equals(input_char_2))
                {
                    System.out.println("Custom characters cannot be the same. Run the program again.");
                    clear_score();
                    break;
                }
                else if (input_char_1.length()>1 || input_char_2.length()>1)
                {
                    System.out.println("Custom characters can only be 1 character long. Run the program again.");
                    clear_score();
                    break;
                }
                else if ( (Character.isLetterOrDigit(input_char_1.charAt(0)) && Character.isLetterOrDigit(input_char_2.charAt(0))) || ((((!Character.isWhitespace(input_char_1.charAt(0)) && !Character.isWhitespace(input_char_2.charAt(0)))&& (!Character.isLetterOrDigit(input_char_1.charAt(0)) && !Character.isLetterOrDigit(input_char_2.charAt(0)))))))
                {
                    boolean running = true;
                    while (running)
                    {
                        System.out.print("Please select the number to make your move. You cannot select the same number twice. Type 'Clear' to end the game: ");
                        String entry = in.next();
                        switch (entry)
                        {
                            case "1":
                                one();
                                break;
                            case "2":
                                two();
                                break;
                            case "3":
                                three();
                                break;
                            case "4":
                                four();
                                break;
                            case "5":
                                five();
                                break;
                            case "6":
                                six();
                                break;
                            case "7":
                                seven();
                                break;
                            case "8":
                                eight();
                                break;
                            case "9":
                                nine();
                                break;
                            case "Clear":
                                clear_score();
                                running = false;
                                break;
                            default:
                                System.out.println("Please enter a valid position");
                        }
                    }
                    break;
                }
                
                
            case "HvC":
                
                ArrayList<Integer> methods_used = new ArrayList<>();
                Collections.addAll(methods_used,1,2,3,4,5,6,7,8,9);
                int counter_computer =0;
                System.out.println("Your turn.");
                System.out.println("Please choose a custom mark for human player");
                input_char_1 = in.next();
                System.out.println("Please choose a custom mark for computer player");
                input_char_2 = in.next();
                while (running_computer)
                {
                    
                    if (input_char_1.equals(input_char_2))
                    {
                        System.out.println("Custom characters cannot be the same. Run the program again.");
                        clear_score();
                        break;
                    }
                    else if (input_char_1.length()>1 || input_char_2.length()>1)
                    {
                        System.out.println("Custom characters can only be 1 character long. Run the program again.");
                        clear_score();
                        break;
                    }
                    else if ( (Character.isLetterOrDigit(input_char_1.charAt(0)) && Character.isLetterOrDigit(input_char_2.charAt(0))) || ((((!Character.isWhitespace(input_char_1.charAt(0)) && !Character.isWhitespace(input_char_2.charAt(0)))&& (!Character.isLetterOrDigit(input_char_1.charAt(0)) && !Character.isLetterOrDigit(input_char_2.charAt(0)))))))
                    {
                        if (counter_computer %2!=0)
                        {
                            System.out.println("Please enter number to move: ");
                            String position_HvC = in.next();
                            switch (position_HvC)
                            {
                                case "1":
                                    counter_computer+=1;
                                    methods_used.set(0,0);
                                    one();
                                
                                    break;
                                case "2":
                                    counter_computer+=1;
                                    methods_used.set(1,0);
                                    two();
                                    break;
                                case "3":
                                    counter_computer+=1;
                                    methods_used.set(2,0);
                                    three();
                                    break;
                                case "4":
                                    counter_computer+=1;
                                    methods_used.set(3,0);
                                    four();
                                    break;
                                case "5":
                                    counter_computer+=1;
                                    methods_used.set(4,0);
                                    five();
                                    break;
                                case "6":
                                    counter_computer+=1;
                                    methods_used.set(5,0);
                                    six();
                                    break;
                                case "7":
                                    counter_computer+=1;
                                    methods_used.set(6,0);
                                    seven();
                                    break;
                                case "8":
                                    counter_computer+=1;
                                    methods_used.set(7,0);
                                    eight();
                                    break;
                                case "9":
                                    counter_computer+=1;
                                    methods_used.set(8,0);
                                    nine();
                                    break;
                                case "Clear":
                                    clear_score();
                                    counter_computer=0;
                                    running_computer = false;
                                    break;
                                default:
                                    System.out.println("Please enter a valid position");
                            }
                        }
                        else if (counter_computer %2 ==0)
                        {
                            System.out.println("Computer's turn.");
                            while (running_random_move)
                            {
                                Random random = new Random();
                                int random_index = random.nextInt(methods_used.size()-1);
                                if (methods_used.get(random_index)==1)
                                {
                                    methods_used.set(random_index,0);
                                    counter_computer+=1;
                                    one();
                                    break;
                                }
                                else if (methods_used.get(random_index)==2)
                                {
                                    methods_used.set(random_index,0);
                                    counter_computer+=1;
                                    two();
                                    break;
                                }
                                else if (methods_used.get(random_index)==3)
                                {
                                    methods_used.set(random_index,0);
                                    counter_computer+=1;
                                    three();
                                    break;
                                }
                                else if (methods_used.get(random_index)==4)
                                {
                                    methods_used.set(random_index,0);
                                    counter_computer+=1;
                                    four();
                                    break;
                                }
                                else if (methods_used.get(random_index)==5)
                                {
                                    methods_used.set(random_index,0);
                                    counter_computer+=1;
                                    five();
                                    break;
                                }
                                else if (methods_used.get(random_index)==6)
                                {
                                    methods_used.set(random_index,0);
                                    counter_computer+=1;
                                    six();
                                    break;
                                }
                                else if (methods_used.get(random_index)==7)
                                {
                                    methods_used.set(random_index,0);
                                    counter_computer+=1;
                                    seven();
                                    break;
                                }
                                else if (methods_used.get(random_index)==8)
                                {
                                    methods_used.set(random_index,0);
                                    counter_computer+=1;
                                    eight();
                                    break;
                                }
                                else if (methods_used.get(random_index)==9)
                                {
                                
                                    methods_used.set(random_index,0);
                                counter_computer+=1;
                                    nine();
                                    break;
                                }
                                else if (methods_used.get(random_index)==0)
                                {
                                    continue;
                                }
                            }
                        }
                    }
                    
                }
            default:
                System.out.println("Please enter choose Human vs. Human or Human vs. Computer as a game mode.");

        }
                
                
        in.close();        
    }


        
        
            
    
    
    public static void tictactoe_score()
    {
        for (int i=0; i<=4; i++)
        {
            System.out.print(grid.get(i));
        }
        
        System.out.println(" ");
        
        for (int i=5; i<=9; i++)
        {
            System.out.print(grid.get(i));
        }
        System.out.println(" ");
        
        
        for (int i=10; i<=14; i++)
        {
            System.out.print(grid.get(i));
        }
        System.out.println(" ");

        for (int i=15; i<=19; i++)
        {
            System.out.print(grid.get(i));
        }
        System.out.println(" ");

        for (int i = 20; i<=24; i++)
        {
            System.out.print(grid.get(i));
        }
        System.out.println(" ");
    }


    public static void one()
    {
        counter +=1;
        //set the move
        if (counter % 2 == 0 && grid.get(0).equals("1"))
        {
            //look at possible win positions
            grid.set(0,input_char_1);
            tictactoe_score();
            if (grid.get(0).equals(input_char_1) && grid.get(2).equals(input_char_1) && grid.get(4).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(0).equals(input_char_1) && grid.get(10).equals(input_char_1) && grid.get(20).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(0).equals(input_char_1) && grid.get(12).equals(input_char_1) && grid.get(24).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (counter == 9)
            {
                System.out.println("Draw. Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }
        }
        //set the move
        else if (counter % 2 != 0 && grid.get(0).equals("1"))
        {
            //look at possible win positions
            grid.set(0,input_char_2);
            tictactoe_score();
            if (grid.get(0).equals(input_char_2) && grid.get(2).equals(input_char_2) && grid.get(4).equals(input_char_2))
            {
                System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }

            else if (grid.get(0).equals(input_char_2) && grid.get(10).equals(input_char_2) && grid.get(20).equals(input_char_2))
            {
                System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }

            else if (grid.get(0).equals(input_char_2) && grid.get(12).equals(input_char_2) && grid.get(24).equals(input_char_2))
            {
                System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }

            else if (counter == 9)
            {
                System.out.println("Draw. Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }
        }
        
        else
        {
            counter -=1;
            System.out.println("This position is not available. Please choose an available position.");
        }
        
    }


    public static void two()
    {
        counter +=1;
        //set the move
        if (counter % 2 == 0 && grid.get(2).equals("2"))
        {
            //look at possible win positions
            grid.set(2,input_char_1);
            tictactoe_score();
            if (grid.get(0).equals(input_char_1) && grid.get(2).equals(input_char_1) && grid.get(4).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(2).equals(input_char_1) && grid.get(12).equals(input_char_1) && grid.get(22).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (counter == 9)
            {
                System.out.println("Draw. Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }
        }
        //set the move
        else if (counter % 2 != 0 && grid.get(2).equals("2"))
        {
            //look at possible win positions
            grid.set(2,input_char_2);
            tictactoe_score();
            if (grid.get(0).equals(input_char_2) && grid.get(2).equals(input_char_2) && grid.get(4).equals(input_char_2))
            {
                System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }

            else if (grid.get(2).equals(input_char_2) && grid.get(12).equals(input_char_2) && grid.get(22).equals(input_char_2))
            {
                System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }

            else if (counter == 9)
            {
                System.out.println("Draw. Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }
        }
        

        else
        {
            counter -=1;
            System.out.println("This position is not available. Please choose an available position.");
        }
        
    }


    public static void three()
    {
        counter +=1;
        //set the move
        if (counter % 2 == 0 && grid.get(4).equals("3"))
        {
            //look at possible win positions
            grid.set(4,input_char_1);
            tictactoe_score();
            if (grid.get(0).equals(input_char_1) && grid.get(2).equals(input_char_1) && grid.get(4).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(4).equals(input_char_1) && grid.get(14).equals(input_char_1) && grid.get(24).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(4).equals(input_char_1) && grid.get(12).equals(input_char_1) && grid.get(20).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (counter == 9)
            {
                System.out.println("Draw. Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }
        }
        //set the move
        else if (counter % 2 != 0 && grid.get(4).equals("3"))
        {
            //look at possible win positions
            grid.set(4,input_char_2);
            tictactoe_score();
            if (grid.get(0).equals(input_char_2) && grid.get(2).equals(input_char_2) && grid.get(4).equals(input_char_2))
            {
                System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }

            else if (grid.get(4).equals(input_char_2) && grid.get(14).equals(input_char_2) && grid.get(24).equals(input_char_2))
            {
                System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }

            else if (grid.get(4).equals(input_char_2) && grid.get(12).equals(input_char_2) && grid.get(20).equals(input_char_2))
            {
                System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }

            else if (counter == 9)
            {
                System.out.println("Draw. Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }
        }
        
        else
        {
            counter -=1;
            System.out.println("This position is not available. Please choose an available position.");
        }
        
    }

    public static void four()
    {
        counter +=1;
        //set the move
        if (counter % 2 == 0 && grid.get(10).equals("4"))
        {
            //look at possible win positions
            grid.set(10,input_char_1);
            tictactoe_score();
            if (grid.get(0).equals(input_char_1) && grid.get(10).equals(input_char_1) && grid.get(20).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(10).equals(input_char_1) && grid.get(12).equals(input_char_1) && grid.get(14).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (counter == 9)
            {
                System.out.println("Draw. Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }
        }
        //set the move
        else if (counter % 2 != 0 && grid.get(10).equals("4"))
        {
            //look at possible win positions
            grid.set(10,input_char_2);
            tictactoe_score();
            if (grid.get(0).equals(input_char_2) && grid.get(10).equals(input_char_2) && grid.get(20).equals(input_char_2))
            {
                System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }

            else if (grid.get(10).equals(input_char_2) && grid.get(12).equals(input_char_2) && grid.get(14).equals(input_char_2))
            {
                System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }

            else if (counter == 9)
            {
                System.out.println("Draw. Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }
        }
        
        else
        {
            counter -=1;
            System.out.println("This position is not available. Please choose an available position.");
        }
        
    }

    public static void five()
    {
        counter +=1;
        //set the move
        if (counter % 2 == 0 && grid.get(12).equals("5"))
        {
            //look at possible win positions
            grid.set(12,input_char_1);
            tictactoe_score();
            if (grid.get(0).equals(input_char_1) && grid.get(12).equals(input_char_1) && grid.get(24).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(2).equals(input_char_1) && grid.get(12).equals(input_char_1) && grid.get(22).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(4).equals(input_char_1) && grid.get(12).equals(input_char_1) && grid.get(20).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(10).equals(input_char_1) && grid.get(12).equals(input_char_1) && grid.get(14).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (counter == 9)
            {
                System.out.println("Draw. Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }
        }
        //set the move
        else if (counter % 2 != 0 && grid.get(12).equals("5"))
        {
            //look at possible win positions
            grid.set(12,input_char_2);
            tictactoe_score();
            if (grid.get(0).equals(input_char_2) && grid.get(12).equals(input_char_2) && grid.get(24).equals(input_char_2))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Computer wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(2).equals(input_char_2) && grid.get(12).equals(input_char_2) && grid.get(22).equals(input_char_2))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Computer wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(4).equals(input_char_2) && grid.get(12).equals(input_char_2) && grid.get(20).equals(input_char_2))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Computer wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(10).equals(input_char_2) && grid.get(12).equals(input_char_2) && grid.get(14).equals(input_char_2))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Computer wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (counter == 9)
            {
                System.out.println("Draw. Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }
        }
        
        else
        {
            counter -=1;
            System.out.println("This position is not available. Please choose an available position.");
        }
        
    }

    public static void six()
    {
        counter +=1;
        //set the move
        if (counter % 2 == 0 && grid.get(14).equals("6"))
        {
            //look at possible win positions
            grid.set(14,input_char_1);
            tictactoe_score();
            if (grid.get(4).equals(input_char_1) && grid.get(14).equals(input_char_1) && grid.get(24).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(10).equals(input_char_1) && grid.get(12).equals(input_char_1) && grid.get(14).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (counter == 9)
            {
                System.out.println("Draw. Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }
        }
        //set the move
        else if (counter % 2 != 0 && grid.get(14).equals("6"))
        {
            //look at possible win positions
            grid.set(14,input_char_2);
            tictactoe_score();
            if (grid.get(4).equals(input_char_2) && grid.get(14).equals(input_char_2) && grid.get(24).equals(input_char_2))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Computer wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(10).equals(input_char_2) && grid.get(12).equals(input_char_2) && grid.get(14).equals(input_char_2))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Computer wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (counter == 9)
            {
                System.out.println("Draw. Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }
        }
        
        else
        {
            counter -=1;
            System.out.println("This position is not available. Please choose an available position.");
        }
        
    }

    public static void seven()
    {
        counter +=1;
        //set the move
        if (counter % 2 == 0 && grid.get(20).equals("7"))
        {
            //look at possible win positions
            grid.set(20,input_char_1);
            tictactoe_score();
            if (grid.get(0).equals(input_char_1) && grid.get(10).equals(input_char_1) && grid.get(20).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(20).equals(input_char_1) && grid.get(22).equals(input_char_1) && grid.get(24).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(4).equals(input_char_1) && grid.get(12).equals(input_char_1) && grid.get(20).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (counter == 9)
            {
                System.out.println("Draw. Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }
        }
        //set the move
        else if (counter % 2 != 0 && grid.get(20).equals("7"))
        {
            //look at possible win positions
            grid.set(20,input_char_2);
            tictactoe_score();
            if (grid.get(0).equals(input_char_2) && grid.get(10).equals(input_char_2) && grid.get(20).equals(input_char_2))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Computer wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(20).equals(input_char_2) && grid.get(22).equals(input_char_2) && grid.get(24).equals(input_char_2))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Computer wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(4).equals(input_char_2) && grid.get(12).equals(input_char_2) && grid.get(20).equals(input_char_2))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Computer wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (counter == 9)
            {
                System.out.println("Draw. Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }
        }

        
        else
        {
            counter -=1;
            System.out.println("This position is not available. Please choose an available position.");
        }
        
    }

    public static void eight()
    {
        counter +=1;
        //set the move
        if (counter % 2 == 0 && grid.get(22).equals("8"))
        {
            //look at possible win positions
            grid.set(22,input_char_1);
            tictactoe_score();
            if (grid.get(20).equals(input_char_1) && grid.get(22).equals(input_char_1) && grid.get(24).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(2).equals(input_char_1) && grid.get(12).equals(input_char_1) && grid.get(22).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (counter == 9)
            {
                System.out.println("Draw. Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }
        }
        //set the move
        else if (counter % 2 != 0 && grid.get(22).equals("8"))
        {
            //look at possible win positions
            grid.set(22,input_char_2);
            tictactoe_score();
            if (grid.get(20).equals(input_char_2) && grid.get(22).equals(input_char_2) && grid.get(24).equals(input_char_2))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Computer wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(2).equals(input_char_2) && grid.get(12).equals(input_char_2) && grid.get(22).equals(input_char_2))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Computer wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (counter == 9)
            {
                System.out.println("Draw. Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }
        }
        
        else
        {
            counter -=1;
            System.out.println("This position is not available. Please choose an available position.");
        }
        
    }

    public static void nine()
    {
        counter +=1;
        //set the move
        if (counter % 2 == 0 && grid.get(24).equals("9"))
        {
            //look at possible win positions
            grid.set(24,input_char_1);
            tictactoe_score();
            if (grid.get(0).equals(input_char_1) && grid.get(12).equals(input_char_1) && grid.get(24).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(4).equals(input_char_1) && grid.get(14).equals(input_char_1) && grid.get(24).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(20).equals(input_char_1) && grid.get(22).equals(input_char_1) && grid.get(24).equals(input_char_1))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 1 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Human wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (counter == 9)
            {
                System.out.println("Draw. Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }
        }
        //set the move
        else if (counter % 2 != 0 && grid.get(24).equals("9"))
        {
            //look at possible win positions
            grid.set(24,input_char_2);
            tictactoe_score();
            if (grid.get(0).equals(input_char_2) && grid.get(12).equals(input_char_2) && grid.get(24).equals(input_char_2))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Computer wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(4).equals(input_char_2) && grid.get(14).equals(input_char_2) && grid.get(24).equals(input_char_2))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Computer wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (grid.get(20).equals(input_char_2) && grid.get(22).equals(input_char_2) && grid.get(24).equals(input_char_2))
            {
                if (game_mode.equals("HvH"))
                {
                    System.out.println("Player 2 wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
                else if (game_mode.equals("HvC"))
                {
                    System.out.println("Computer wins! Please enter 'Clear' to start new game.");
                    running_computer= false;
                    running_random_move =false;
                }
            }

            else if (counter == 9)
            {
                System.out.println("Draw. Please enter 'Clear' to start new game.");
                running_computer= false;
                running_random_move =false;
            }
        }
        
        else
        {
            counter -=1;
            System.out.println("This position is not available. Please choose an available position.");
        }
        
    }

    public static void clear_score()
    {
        grid.set(0, "1");
        grid.set(2, "2");
        grid.set(4, "3");
        grid.set(10, "4");
        grid.set(12, "5");
        grid.set(14, "6");
        grid.set(20, "7");
        grid.set(22, "8");
        grid.set(24, "9");
        counter = 0;
    }

}