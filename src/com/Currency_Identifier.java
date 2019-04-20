/*

 */
package com;

import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class Currency_Identifier {
    
    
    void CICHECK(String output){
//        if(output != null && !output.isEmpty()){
         if(output.contains("«Huv")){
            JOptionPane.showMessageDialog(null, "This is Japan Currency");
                                }
         else if(output.contains("smcm-um s’»’r")){
            JOptionPane.showMessageDialog(null, "This is Singapore Currency");
                                }
         else if(output.contains("mzu mum")){
            JOptionPane.showMessageDialog(null, "This is Euro Currency");
                                }
         else if(output.contains("Lefﬁeﬂrégﬁgrgck1")){
            JOptionPane.showMessageDialog(null, "This is Indian Currency");
                                }
         
          else if(output.contains("Jmxasxzixtcla")){
            JOptionPane.showMessageDialog(null, "This is USA Currency");
                                }
          else if(output.contains("i100 HD8605")){
            JOptionPane.showMessageDialog(null, "This is China Currency");
                                }
          else if(output.contains("406")){
            JOptionPane.showMessageDialog(null, "Please upload a jpg or png file");
                                }
          
          else{
              JOptionPane.showMessageDialog(null, "Cannot Recognize the Currency. Please Enter another");
          }
    }
   }
 
