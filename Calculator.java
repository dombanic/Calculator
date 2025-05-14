// Calculator.java
// Lab 11 - The Calculator Component Program - Part 1
// Student, starting version

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator
{
	public static void main(String args[])
	{
		AppWindow tester = new AppWindow();
		tester.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tester.setSize(800,600);
		tester.setVisible(true);
	}
}

class AppWindow extends JFrame
{
   private Container contentPane;
   
   private JFormattedTextField intField;
   private JPanel upPanel, downPanel; 
   private JSplitPane splitPane;
   private String currentValue;
   private String newValue;
   private String first = "0";
   private String second = "0";
   private int operation = 0;
   private double NEW = 0;
   private double memory = 0;
   private double secondNumber = 0;
   
   private JButton MC, MR, MS, M, m, ex, xy, fourroot, six, minu, plumin, onex;
   private JButton PI, CE, C, log, ln, tan, arctan, sev, fiv, per, peri, z;
   private JButton ten, two, root, sin, arcsin, eig, nin, n, one, tw, e, time;
   private JButton xpower, cubed, cubeRoot, cos, arccos, fou, plus, thr, d;
   
   private Font numbersFont, textFont;
   
	public AppWindow()
	{
      super("Calculator");
      try
      {
         setIconImage(ImageIO.read(new File("Calculator.png")));
      }

      catch (Exception e)
      {
         System.out.println(e);
      }
      
      contentPane = getContentPane();
      splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
      
      upPanel = new JPanel();
      downPanel = new JPanel();
      
      numbersFont = new Font("Courier", Font.BOLD, 28);
      textFont = new Font("Arial", Font.PLAIN, 36);
      
      intField = new JFormattedTextField(new Double(0.0));
      intField.setFont(textFont);
      intField.setHorizontalAlignment(JLabel.RIGHT);
      
      MC = new JButton("MC");
      MC.setFont(numbersFont);
      MC.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            memory = 0;
         }
      });
		MR = new JButton("MR");
      MR.setFont(numbersFont);
      MR.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               intField.setText(Double.toString(memory));
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
		MS = new JButton("MS");
      MS.setFont(numbersFont);
      MS.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               memory = Double.parseDouble(intField.getText());
               intField.setText("0");
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
		M = new JButton("M+");
      M.setFont(numbersFont);
      M.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               NEW = memory + Double.parseDouble(intField.getText());;
               newValue = Double.toString(NEW);
               first = newValue;
               second = "";
               intField.setText(newValue);
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      m = new JButton("M-");
      m.setFont(numbersFont);
      m.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               NEW = memory - Double.parseDouble(intField.getText());;
               newValue = Double.toString(NEW);
               first = newValue;
               second = "";
               intField.setText(newValue);
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      PI = new JButton("\u03C0");
      PI.setFont(numbersFont);
      PI.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               newValue = "3.14159265";
               intField.setText(newValue);
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
		CE = new JButton("CE");
		CE.setFont(numbersFont);
      CE.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
               intField.setText("0");
         }
      });
      C = new JButton("C");
		C.setFont(numbersFont);
      C.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
               memory = 0;
               intField.setText("0");
         }
      });
      log = new JButton("log");
      log.setFont(numbersFont);
      log.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               intField.setText("log(");
               operation = 10;
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      ln = new JButton("ln");
      ln.setFont(numbersFont);
      ln.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               intField.setText("ln(");
               operation = 11;
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      ten = new JButton("10^x");
		ten.setFont(numbersFont);
      ten.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               intField.setText("10^");
               operation = 6;
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      two = new JButton("x^2");
		two.setFont(numbersFont);
      two.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            secondNumber = Double.parseDouble(intField.getText());
            NEW = Math.pow(secondNumber,2);
            newValue = Double.toString(NEW);
            first = newValue;
            second = "";
            intField.setText(newValue);
         }
      });
      root = new JButton("\u221A");
		root.setFont(numbersFont);
      root.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               intField.setText("\u221A");
               operation = 8;
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      sin = new JButton("sin");
      sin.setFont(numbersFont);
      sin.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               intField.setText("sin(");
               operation = 12;
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      arcsin = new JButton("arcsin");
      arcsin.setFont(numbersFont);
      arcsin.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               intField.setText("arcsin(");
               operation = 15;
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      xpower = new JButton("2^x");
		xpower.setFont(numbersFont);
      xpower.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               intField.setText("2^");
               operation = 7;
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      cubed = new JButton("x^3");
		cubed.setFont(numbersFont);
      cubed.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            secondNumber = Double.parseDouble(intField.getText());
            NEW = Math.pow(secondNumber,3);
            newValue = Double.toString(NEW);
            first = newValue;
            second = "";
            intField.setText(newValue);
         }
      });
      cubeRoot = new JButton("\u221B");
		cubeRoot.setFont(numbersFont);
      cubeRoot.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               intField.setText("\u221B");
               operation = 9;
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      cos = new JButton("cos");
      cos.setFont(numbersFont);
      cos.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               intField.setText("cos(");
               operation = 13;
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      arccos = new JButton("arccos");
      arccos.setFont(numbersFont);
      arccos.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               intField.setText("arccos(");
               operation = 16;
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      ex = new JButton("e^x");
      ex.setFont(numbersFont);
      ex.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               intField.setText("e^");
               operation = 19;
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      xy = new JButton("x^y");
      xy.setFont(numbersFont);
      xy.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               first = intField.getText();
               
               intField.setText("");
               operation = 5;
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      fourroot = new JButton("\u221C");
      fourroot.setFont(numbersFont);
      fourroot.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               intField.setText("\u221C");
               operation = 18;
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      tan = new JButton("tan");
      tan.setFont(numbersFont);
      tan.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               intField.setText("tan(");
               operation = 14;
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      arctan = new JButton("arctan");
      arctan.setFont(numbersFont);
      arctan.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               intField.setText("arctan(");
               operation = 17;
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      sev = new JButton("7");
      sev.setFont(numbersFont);
      sev.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               currentValue = intField.getText();
               newValue = "";
               if (currentValue.equals("0") || currentValue.equals("0.0"))
               {
                  newValue = "7";
               }
               else
               {
                  newValue = currentValue + "7";
               }
               intField.setText(newValue);
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      eig = new JButton("8");
      eig.setFont(numbersFont);
      eig.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               currentValue = intField.getText();
               newValue = "";
               if (currentValue.equals("0") || currentValue.equals("0.0"))
               {
                  newValue = "8";
               }
               else
               {
                  newValue = currentValue + "8";
               }
               intField.setText(newValue);
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      nin = new JButton("9");
      nin.setFont(numbersFont);
      nin.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               currentValue = intField.getText();
               newValue = "";
               if (currentValue.equals("0") || currentValue.equals("0.0"))
               {
                  newValue = "9";
               }
               else
               {
                  newValue = currentValue + "9";
               }
               intField.setText(newValue);
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      plus = new JButton("+");
      plus.setFont(numbersFont);
      plus.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               first = intField.getText();
               
               intField.setText("");
               operation = 1;
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      n = new JButton("n!");
      n.setFont(numbersFont);
      n.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            secondNumber = Double.parseDouble(intField.getText());
            NEW = 1;
            for (int k = 1; k <= secondNumber; k++)
            {
               NEW *= k;
            }
            newValue = Double.toString(NEW);
            first = newValue;
            second = "";
            intField.setText(newValue);
         }
      });
      fou = new JButton("4");
      fou.setFont(numbersFont);
      fou.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               currentValue = intField.getText();
               newValue = "";
               if (currentValue.equals("0") || currentValue.equals("0.0"))
               {
                  newValue = "4";
               }
               else
               {
                  newValue = currentValue + "4";
               }
               intField.setText(newValue);
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      fiv = new JButton("5");
      fiv.setFont(numbersFont);
      fiv.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               currentValue = intField.getText();
               newValue = "";
               if (currentValue.equals("0") || currentValue.equals("0.0"))
               {
                  newValue = "5";
               }
               else
               {
                  newValue = currentValue + "5";
               }
               intField.setText(newValue);
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      six = new JButton("6");
      six.setFont(numbersFont);
      six.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               currentValue = intField.getText();
               newValue = "";
               if (currentValue.equals("0") || currentValue.equals("0.0"))
               {
                  newValue = "6";
               }
               else
               {
                  newValue = currentValue + "6";
               }
               intField.setText(newValue);
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      minu = new JButton("-");
      minu.setFont(numbersFont);
      minu.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               first = intField.getText();
               
               intField.setText("");
               operation = 2;
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      per = new JButton("%");
      per.setFont(numbersFont);
      per.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               first = intField.getText();
               
               intField.setText("");
               operation = 20;
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      one = new JButton("1");
      one.setFont(numbersFont);
      one.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               currentValue = intField.getText();
               newValue = "";
               if (currentValue.equals("0") || currentValue.equals("0.0"))
               {
                  newValue = "1";
               }
               else
               {
                  newValue = currentValue + "1";
               }
               intField.setText(newValue);
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      tw = new JButton("2");
      tw.setFont(numbersFont);
      tw.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               currentValue = intField.getText();
               newValue = "";
               if (currentValue.equals("0") || currentValue.equals("0.0"))
               {
                  newValue = "2";
               }
               else
               {
                  newValue = currentValue + "2";
               }
               intField.setText(newValue);
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      thr = new JButton("3");
      thr.setFont(numbersFont);
      thr.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               currentValue = intField.getText();
               newValue = "";
               if (currentValue.equals("0") || currentValue.equals("0.0"))
               {
                  newValue = "3";
               }
               else
               {
                  newValue = currentValue + "3";
               }
               intField.setText(newValue);
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      time = new JButton("*");
      time.setFont(numbersFont);
      time.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               first = intField.getText();
               
               intField.setText("");
               operation = 3;
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      plumin = new JButton("+/-");
      plumin.setFont(numbersFont);
      plumin.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            double firstNumber = Double.parseDouble(intField.getText());
            NEW = -1 * firstNumber;
            newValue = Double.toString(NEW);
            first = newValue;
            second = "";
            intField.setText(newValue);
          }
      });
      peri = new JButton(".");
      peri.setFont(numbersFont);
      peri.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               currentValue = intField.getText();
               newValue = "";
               newValue = currentValue + ".";
               intField.setText(newValue);
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      z = new JButton("0");
      z.setFont(numbersFont);
      z.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               currentValue = intField.getText();
               newValue = "";
               if (currentValue.equals("0") || currentValue.equals("0.0"))
               {
                  newValue = "0";
               }
               else
               {
                  newValue = currentValue + "0";
               }
               intField.setText(newValue);
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      e = new JButton("=");
      e.setFont(numbersFont);
      e.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            double firstNumber = Double.parseDouble(first);
            if (operation == 1)
            { 
               secondNumber = Double.parseDouble(intField.getText());
               NEW = firstNumber + secondNumber;
               newValue = Double.toString(NEW);
               first = newValue;
               second = "";
               intField.setText(newValue);
            }
            else if (operation == 2)
            {
               secondNumber = Double.parseDouble(intField.getText());
               NEW = firstNumber - secondNumber;
               newValue = Double.toString(NEW);
               first = newValue;
               second = "";
               intField.setText(newValue);
            }
            else if (operation == 3)
            {
               secondNumber = Double.parseDouble(intField.getText());
               NEW = firstNumber * secondNumber;
               newValue = Double.toString(NEW);
               first = newValue;
               second = "";
               intField.setText(newValue);
            }
            else if (operation == 4)
            {
               secondNumber = Double.parseDouble(intField.getText());
               if (secondNumber == 0)
               {
                  intField.setText("Division by zero");
               }
               else
               {
                  NEW = firstNumber / secondNumber;
                  newValue = Double.toString(NEW);
                  first = newValue;
                  second = "";
                  intField.setText(newValue);
               }
            }
            else if (operation == 5)
            {
               secondNumber = Double.parseDouble(intField.getText());
               NEW = Math.pow(firstNumber,secondNumber);
               newValue = Double.toString(NEW);
               first = newValue;
               second = "";
               intField.setText(newValue);
            }
            else if (operation == 6)
            {
               first = intField.getText();
               for (int k = 3; k < first.length(); k++)
               {
                  second += first.charAt(k);
               }
               secondNumber = Double.parseDouble(second);
               NEW = Math.pow(10,secondNumber);
               newValue = Double.toString(NEW);
               first = newValue;
               second = "";
               intField.setText(newValue);
            }
            else if (operation == 7)
            {
               first = intField.getText();
               for (int k = 2; k < first.length(); k++)
               {
                  second += first.charAt(k);
               }
               secondNumber = Double.parseDouble(second);
               NEW = Math.pow(2,secondNumber);
               newValue = Double.toString(NEW);
               first = newValue;
               second = "";
               intField.setText(newValue);
            }
            else if (operation == 8)
            {
               first = intField.getText();
               for (int k = 1; k < first.length(); k++)
               {
                  second += first.charAt(k);
               }
               secondNumber = Double.parseDouble(second);
               if (secondNumber < 0)
               {
                  intField.setText("Cannot be negative");
               }
               else
               {
                  NEW = Math.sqrt(secondNumber);
                  newValue = Double.toString(NEW);
                  first = newValue;
                  second = "";
                  intField.setText(newValue);
               }
            }
            else if (operation == 9)
            {
               first = intField.getText();
               for (int k = 1; k < first.length(); k++)
               {
                  second += first.charAt(k);
               }
               secondNumber = Double.parseDouble(second);
               NEW = Math.cbrt(secondNumber);
               newValue = Double.toString(NEW);
               first = newValue;
               second = "";
               intField.setText(newValue);
            }
            else if (operation == 10)
            {
               first = intField.getText();
               for (int k = 4; k < first.length(); k++)
               {
                  second += first.charAt(k);
               }
               secondNumber = Double.parseDouble(second);
               System.out.println(secondNumber);
               NEW = Math.log10(secondNumber);
               System.out.println(NEW);
               newValue = Double.toString(NEW);
               first = newValue;
               second = "";
               intField.setText(newValue);
            }
            else if (operation == 11)
            {
               first = intField.getText();
               for (int k = 3; k < first.length(); k++)
               {
                  second += first.charAt(k);
               }
               secondNumber = Double.parseDouble(second);
               System.out.println(secondNumber);
               NEW = Math.log(secondNumber);
               System.out.println(NEW);
               newValue = Double.toString(NEW);
               first = newValue;
               second = "";
               intField.setText(newValue);
            }
            else if (operation == 12)
            {
               first = intField.getText();
               for (int k = 4; k < first.length(); k++)
               {
                  second += first.charAt(k);
               }
               secondNumber = Double.parseDouble(second);
               NEW = Math.sin(secondNumber);
               newValue = Double.toString(NEW);
               first = newValue;
               second = "";
               intField.setText(newValue);
            }
            else if (operation == 13)
            {
               first = intField.getText();
               for (int k = 4; k < first.length(); k++)
               {
                  second += first.charAt(k);
               }
               secondNumber = Double.parseDouble(second);
               NEW = Math.cos(secondNumber);
               newValue = Double.toString(NEW);
               first = newValue;
               second = "";
               intField.setText(newValue);
            }
            else if (operation == 14)
            {
               first = intField.getText();
               for (int k = 4; k < first.length(); k++)
               {
                  second += first.charAt(k);
               }
               secondNumber = Double.parseDouble(second);
               NEW = Math.tan(secondNumber);
               newValue = Double.toString(NEW);
               first = newValue;
               second = "";
               intField.setText(newValue);
            }
            else if (operation == 15)
            {
               first = intField.getText();
               for (int k = 7; k < first.length(); k++)
               {
                  second += first.charAt(k);
               }
               secondNumber = Double.parseDouble(second);
               if (secondNumber > 1)
               {
                  intField.setText("Can't be greater then one");
                  second = "";
               }
               else
               {
                  NEW = Math.asin(secondNumber);
                  newValue = Double.toString(NEW);
                  first = newValue;
                  second = "";
                  intField.setText(newValue);
               }
            }
            else if (operation == 16)
            {
               first = intField.getText();
               for (int k = 7; k < first.length(); k++)
               {
                  second += first.charAt(k);
               }
               secondNumber = Double.parseDouble(second);
               if (secondNumber > 1)
               {
                  intField.setText("Can't be greater then one");
                  second = "";
               }
               else
               {
                  NEW = Math.acos(secondNumber);
                  newValue = Double.toString(NEW);
                  first = newValue;
                  second = "";
                  intField.setText(newValue);
               }
            }
            else if (operation == 17)
            {
               first = intField.getText();
               for (int k = 7; k < first.length(); k++)
               {
                  second += first.charAt(k);
               }
               secondNumber = Double.parseDouble(second);
               NEW = Math.atan(secondNumber);
               newValue = Double.toString(NEW);
               first = newValue;
               second = "";
               intField.setText(newValue);
            }
            else if (operation == 18)
            {
               first = intField.getText();
               for (int k = 1; k < first.length(); k++)
               {
                  second += first.charAt(k);
               }
               secondNumber = Double.parseDouble(second);
               NEW = Math.pow(secondNumber,0.25);
               newValue = Double.toString(NEW);
               first = newValue;
               second = "";
               intField.setText(newValue);
            }
            else if (operation == 19)
            {
               first = intField.getText();
               for (int k = 2; k < first.length(); k++)
               {
                  second += first.charAt(k);
               }
               secondNumber = Double.parseDouble(second);
               NEW = Math.pow(Math.E,secondNumber);
               newValue = Double.toString(NEW);
               first = newValue;
               second = "";
               intField.setText(newValue);
            }
            else if (operation == 20)
            {
               secondNumber = Double.parseDouble(intField.getText());
               if (secondNumber == 0)
               {
                  intField.setText("Division by zero");
               }
               else
               {
                  NEW = firstNumber % secondNumber;
                  newValue = Double.toString(NEW);
                  first = newValue;
                  second = "";
                  intField.setText(newValue);
               }
            }
         }
      });
      d = new JButton("/");
      d.setFont(numbersFont);
      d.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               first = intField.getText();
               
               intField.setText("");
               operation = 4;
            }
            catch (NumberFormatException ex)
            {
               intField.setText("Error");
            }
         }
      });
      onex = new JButton("1/x");
      onex.setFont(numbersFont);
      onex.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            double firstNumber = Double.parseDouble(intField.getText());
            if (firstNumber == 0.0)
            {
               intField.setText("Division by zero");
            }
            else
            {
                NEW = 1 / firstNumber;
                newValue = Double.toString(NEW);
                first = newValue;
                second = "";
                intField.setText(newValue);
             }
          }
      });
      
      upPanel.setLayout(new GridLayout(1,1));
      upPanel.add(intField);
      
		downPanel.setLayout(new GridLayout(9,5));
            
      downPanel.add(MC);
		downPanel.add(MR);
		downPanel.add(MS);
		downPanel.add(M);
      downPanel.add(m);
		downPanel.add(PI);
		downPanel.add(CE);
		downPanel.add(C);
      downPanel.add(log);
		downPanel.add(ln);
		downPanel.add(ten);
		downPanel.add(two);
      downPanel.add(root);
		downPanel.add(sin);
		downPanel.add(arcsin);
		downPanel.add(xpower);
      downPanel.add(cubed);
		downPanel.add(cubeRoot);
		downPanel.add(cos);
		downPanel.add(arccos);
      downPanel.add(ex);
      downPanel.add(xy);
      downPanel.add(fourroot);
      downPanel.add(tan);
      downPanel.add(arctan);
      downPanel.add(sev);
      downPanel.add(eig);
      downPanel.add(nin);
      downPanel.add(plus);
      downPanel.add(n);
      downPanel.add(fou);
      downPanel.add(fiv);
      downPanel.add(six);
      downPanel.add(minu);
      downPanel.add(per);
      downPanel.add(one);
      downPanel.add(tw);
      downPanel.add(thr);
      downPanel.add(time);
      downPanel.add(plumin);
      downPanel.add(peri);
      downPanel.add(z);
      downPanel.add(e);
      downPanel.add(d);
      downPanel.add(onex);
      
      splitPane.setTopComponent(upPanel);
		splitPane.setBottomComponent(downPanel);
      
      contentPane.add(splitPane);
	   }
}

