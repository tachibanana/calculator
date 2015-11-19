package com.calc
import wslite.soap.*
class Services {

	def doAdd(num1 , num2){
		def client = new SOAPClient('http://www.dneonline.com/calculator.asmx')
		def response = client.send(SOAPAction:'http://tempuri.org/Add'){
			body{
				Add(xmlns:'http://tempuri.org/'){
					intA(num1)
					intB(num2)
					}
			}
		}
		
		response.AddResponse.AddResult
	}
	
	def doSub(num1 , num2){
		def client = new SOAPClient('http://www.dneonline.com/calculator.asmx')
		def response = client.send(SOAPAction:'http://tempuri.org/Subtract'){
			body{
				Subtract(xmlns:'http://tempuri.org/'){
					intA(num1)
					intB(num2)
				}
			}
		}
		response.SubtractResponse.SubtractResult
	}
	
	def doMul(num1 , num2){
		def client = new SOAPClient('http://www.dneonline.com/calculator.asmx')
		def response = client.send(SOAPAction:'http://tempuri.org/Multiply'){
			body{
				Multiply(xmlns:'http://tempuri.org/'){
					intA(num1)
					intB(num2)
				}
			}
		}
	}
	
	def doDiv(num1 , num2){
		def client = new SOAPClient('http://www.dneonline.com/calculator.asmx')
		def response = client.send(SOAPAction:'http://tempuri.org/Divide'){
			body{
				Divide(xmlns:'http://tempuri.org/'){
					intA(num1)
					intB(num2)
				}
			}
		}
	}
}
