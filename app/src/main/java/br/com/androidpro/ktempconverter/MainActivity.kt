package br.com.androidpro.ktempconverter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var celciusRadio: RadioButton
    lateinit var fahreinheitRadio: RadioButton
    lateinit var converterButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.valorTemp) as EditText

        celciusRadio = findViewById(R.id.celciusRadio) as RadioButton
        fahreinheitRadio = findViewById(R.id.fahreinheitRadio) as RadioButton

        converterButton = findViewById(R.id.converterButton) as Button
        converterButton.setOnClickListener { converter(it) }
    }

    fun converter(view: View) {
        val tempS: String = editText.text.toString()
        if (!tempS.isEmpty()) {
            try {
                var temp: Double = editText.text.toString().toDouble()

                if (celciusRadio.isChecked) {
                    temp = (temp - 32) * 5 / 9
                } else if (fahreinheitRadio.isChecked) {
                    temp = temp * 9 / 5 + 32
                }

                editText.setText(temp.toString())
            } catch (e: Exception) {
                Toast.makeText(
                        view.context,
                        "Erro ao converter medida! Error: ${e.message}",
                        Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(
                    view.context,
                    "Digite a temperadura!",
                    Toast.LENGTH_SHORT).show()
        }
    }
}
