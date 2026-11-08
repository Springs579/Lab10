import java.util.Scanner;
public class SafeInput
{
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";
        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while(retString.length() == 0);

        return retString;
    }
    public static int getInt(Scanner pipe, String prompt)
    {
        int retInt = 0;
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");

            if(pipe.hasNextInt())
            {
                retInt = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                System.out.println("You must enter a valid integer!");
                pipe.nextLine();
            }

        } while(!done);

        return retInt;
    }
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retDouble = 0;
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");

            if(pipe.hasNextDouble())
            {
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                System.out.println("You must enter a valid decimal number!");
                pipe.nextLine();
            }

        } while(!done);

        return retDouble;
    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retInt = 0;
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");

            if(pipe.hasNextInt())
            {
                retInt = pipe.nextInt();
                pipe.nextLine();

                if(retInt >= low && retInt <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("Number must be between " + low + " and " + high + ".");
                }
            }
            else
            {
                System.out.println("You must enter a valid integer!");
                pipe.nextLine();
            }

        } while(!done);

        return retInt;
    }
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retDouble = 0;
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");

            if(pipe.hasNextDouble())
            {
                retDouble = pipe.nextDouble();
                pipe.nextLine();

                if(retDouble >= low && retDouble <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("Number must be between " + low + " and " + high + ".");
                }
            }
            else
            {
                System.out.println("You must enter a valid decimal number!");
                pipe.nextLine();
            }

        } while(!done);

        return retDouble;
    }
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String response = "";

        boolean done = false;
        boolean answer = false;

        do
        {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine();

            if(response.equalsIgnoreCase("Y"))
            {
                answer = true;
                done = true;
            }
            else if(response.equalsIgnoreCase("N"))
            {
                answer = false;
                done = true;
            }
            else
            {
                System.out.println("Please enter Y or N.");
            }

        } while(!done);

        return answer;
    }
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String response = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();

            if(response.matches(regEx))
            {
                done = true;
            }
            else
            {
                System.out.println("Input does not match the required format. Try again.");
            }

        } while(!done);

        return response;
    }
    public static void prettyHeader(String msg)
    {
        for(int i = 0; i < 60; i++)
        {
            System.out.print("*");
        }

        System.out.println();

        int spaces = 54 - msg.length();
        int leftSpaces = spaces / 2;
        int rightSpaces = spaces - leftSpaces;

        System.out.print("***");

        for(int i = 0; i < leftSpaces; i++)
        {
            System.out.print(" ");
        }

        System.out.print(msg);

        for(int i = 0; i < rightSpaces; i++)
        {
            System.out.print(" ");
        }

        System.out.println("***");

        for(int i = 0; i < 60; i++)
        {
            System.out.print("*");
        }

        System.out.println();
    }
}