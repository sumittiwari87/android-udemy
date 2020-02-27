package `in`.co.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private  var operand1:Double? =null
    private var operand2:Double = 0.0
    private var pendingOperation = "="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listenerBtn =  View.OnClickListener { v ->
            val b = v as Button
            editTextInp.append(b.text)
        }

        button0.setOnClickListener(listenerBtn)
        button1.setOnClickListener(listenerBtn)
        button2.setOnClickListener(listenerBtn)
        button3.setOnClickListener(listenerBtn)
        button4.setOnClickListener(listenerBtn)
        button5.setOnClickListener(listenerBtn)
        button6.setOnClickListener(listenerBtn)
        button7.setOnClickListener(listenerBtn)
        button8.setOnClickListener(listenerBtn)
        button9.setOnClickListener(listenerBtn)
        buttonDot.setOnClickListener(listenerBtn)
        buttonNeg.setOnClickListener { v ->
            val value = editTextInp.text.toString()
            if (value.isEmpty()){
                editTextInp.setText("-")
            }else{
                try {
                    var doubleValue = value.toDouble()
                    doubleValue *= -1
                    editTextInp.setText(doubleValue.toString())
                }catch (e:NumberFormatException){
                    editTextInp.setText("")
                }
            }
        }

        var listenerOper = View.OnClickListener { v ->
                val op = (v as Button).text.toString()
                val value = editTextInp.text.toString()
                if(value.isNotEmpty()){
                    performOperation(value,op)
                }
                pendingOperation = op
                operation.text = pendingOperation
        }

        buttonDiv.setOnClickListener(listenerOper)
        buttonMinus.setOnClickListener(listenerOper)
        buttonMul.setOnClickListener(listenerOper)
        buttonPlus.setOnClickListener(listenerOper)
        buttonEqual.setOnClickListener(listenerOper)

    }

    private fun performOperation(value: String,op:String){
        if(operand1 == null ){
            operand1 = value.toDouble()
        }else{
            operand2 = value.toDouble()
            if(pendingOperation == "="){
                pendingOperation = op
            }

            when(pendingOperation){
                "=" -> operand1 = operand2
                "/" -> operand1 = if(operand2 ==0.0){
                    Double.NaN
                }else{
                    operand1!! / operand2
                }
                "*" -> operand1 = operand1!! * operand2
                "-" -> operand1 = operand1!! - operand2
                "+" -> operand1 = operand1!! + operand2
            }
        }
        editTextResult.setText(operand1.toString())
        editTextInp.setText("")
    }
}
