package com.calc

import groovy.swing.SwingBuilder

import java.awt.*

import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTextField

class GUI extends SwingBuilder{
	
	def frame
	def contentPane
	def firstLayer
	def secondLayer
	def thirdLayer
	def forthLayer
	def txField
	def btn7 , btn8 , btn9 , btnDiv
	def btn4 , btn5 , btn6 , btnMul
	def btn1 , btn2 , btn3 , btnMin
	def btn0 , btnClr , btnEql , btnAdd
	def operator , num1 , num2
	
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
		txField = new JTextField(columns:20)
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
		
		contentPane.add(txField)
		contentPane.add(firstLayer)
		contentPane.add(secondLayer)
		contentPane.add(thirdLayer)
		
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
		
		frame.setResizable(false)
		frame.show()
		
	}
	
}
