package com.calc

import groovy.swing.SwingBuilder

import java.awt.*
import java.awt.event.ActionListener

import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.SwingConstants

class GUI extends SwingBuilder{
	
	JFrame frame
	JPanel contentPane
	JPanel firstLayer
	JPanel secondLayer
	JPanel thirdLayer
	JPanel forthLayer
	JTextField txField
	JButton btn7 , btn8 , btn9 , btnDiv
	JButton btn4 , btn5 , btn6 , btnMul
	JButton btn1 , btn2 , btn3 , btnMin
	JButton btn0 , btnClr , btnEql , btnAdd
	String operator
	def tempNum
	
	def edt(){
	
		//panels
		firstLayer = new JPanel(new FlowLayout(FlowLayout.CENTER))
		secondLayer = new JPanel(new FlowLayout(FlowLayout.CENTER))
		thirdLayer = new JPanel(new FlowLayout(FlowLayout.CENTER))
		forthLayer = new JPanel(new FlowLayout(FlowLayout.CENTER))
		contentPane = new JPanel()
		
		BoxLayout box = new BoxLayout(contentPane , BoxLayout.Y_AXIS)
		contentPane.setLayout(box)
		
		
		
		//frame
		frame = new JFrame(title:'Calculator' , 
			defaultCloseOperation:JFrame.EXIT_ON_CLOSE , 
			size:[320 , 210] , 
			locationRelativeTo:null)
		frame.contentPane = contentPane

		//first layer
		txField = new JTextField(text:'0',columns:20,editable:false)
		txField.setHorizontalAlignment(SwingConstants.RIGHT)
		btn7 = new JButton(text:'7')
		btn8 = new JButton(text:'8')
		btn9 = new JButton(text:'9')
		btnDiv = new JButton(text:'/')
		
		firstLayer.add(btn7)
		firstLayer.add(btn8)
		firstLayer.add(btn9)
		firstLayer.add(btnDiv)
		
		//second layer
		btn4 = new JButton(text:'4')
		btn5 = new JButton(text:'5')
		btn6 = new JButton(text:'6')
		btnMul = new JButton(text:'X')
		
		secondLayer.add(btn4)
		secondLayer.add(btn5)
		secondLayer.add(btn6)
		secondLayer.add(btnMul)
		
		//third layer
		btn1 = new JButton(text:'1')
		btn2 = new JButton(text:'2')
		btn3 = new JButton(text:'3')
		btnMin = new JButton(text:'-')
		
		thirdLayer.add(btn1)
		thirdLayer.add(btn2)
		thirdLayer.add(btn3)
		thirdLayer.add(btnMin)
		
		
		//forth layer
		btn0 = new JButton(text:'0')
		btnClr = new JButton(text:'AC')
		btnEql = new JButton(text:'=')
		btnAdd = new JButton(text:'+')
		
		forthLayer.add(btn0)
		forthLayer.add(btnClr)
		forthLayer.add(btnEql)
		forthLayer.add(btnAdd)
		
		contentPane.add(txField)
		contentPane.add(firstLayer)
		contentPane.add(secondLayer)
		contentPane.add(thirdLayer)
		contentPane.add(forthLayer)
		
		//event
		btn1.addActionListener(clickBtn as ActionListener)
		btn2.addActionListener(clickBtn as ActionListener)
		btn3.addActionListener(clickBtn as ActionListener)
		btn4.addActionListener(clickBtn as ActionListener)
		btn5.addActionListener(clickBtn as ActionListener)
		btn6.addActionListener(clickBtn as ActionListener)
		btn7.addActionListener(clickBtn as ActionListener)
		btn8.addActionListener(clickBtn as ActionListener)
		btn9.addActionListener(clickBtn as ActionListener)
		btn0.addActionListener(clickBtn as ActionListener)
		btnAdd.addActionListener(clickOperator as ActionListener)
		btnMin.addActionListener(clickOperator as ActionListener)
		btnMul.addActionListener(clickOperator as ActionListener)
		btnDiv.addActionListener(clickOperator as ActionListener)
		btnEql.addActionListener(clickEqual as ActionListener)
		btnClr.addActionListener(clickClear as ActionListener)
		
		frame.setResizable(false)
		frame.show()
		
	}
	
	def clickBtn = {if(txField.text.equals('0') || tempNum != 0) txField.text = it.getActionCommand() else txField.text += it.getActionCommand()} 
	
	def clickClear = {txField.text = "0"; tempNum = 0}
	def clickOperator = {tempNum = Integer.parseInt(txField.text); txField.text = '0'; operator = it.getActionCommand()}
	def clickEqual = {
		Services s = new Services()
		
		if(operator.equals("+")) {tempNum = s.doAdd(tempNum , Integer.parseInt(txField.text)); txField.text = tempNum}
		if(operator.equals("-")) {tempNum = s.doMin(tempNum , Integer.parseInt(txField.text)); txField.text = tempNum}
		if(operator.equals("X")) {tempNum = s.doMul(tempNum, Integer.parseInt(txField.text)); txField.text = tempNum}
		if(operator.equals("/")) {tempNum = s.doDiv(tempNum , Integer.parseInt(txField.text)); txField.text = tempNum}
		
		}
}
