package com.example.clase3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clase3.databinding.ActivityMainBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonRegistrar.setOnClickListener(view -> {
            String nombre = binding.editTextNombre.getText().toString();
            String apellido = binding.editTextApellido.getText().toString();
            String edadStr = binding.textFieldEdad.getEditText().getText().toString();

            String textoToast = nombre + " " + apellido + ": " + edadStr;
            Toast.makeText(this, textoToast, Toast.LENGTH_SHORT).show();
        });

        binding.buttonCleanForm.setOnClickListener(view -> {
            binding.editTextNombre.setText("");
            binding.editTextApellido.setText("");
            binding.textFieldEdad.getEditText().setText("");
        });

        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                binding.textViewSb.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        binding.seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                binding.textViewSb2.setText(String.valueOf(i - 20));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        binding.floatingActionButton.setOnClickListener(view -> {
            mostrarDialogo();
        });

        binding.floatingActionButton2.setOnClickListener(view -> mostrarDialogoConMaterial());

    }

    public void mostrarDialogo() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("mensaje del profesor a los alumnos");
        alertDialog.setMessage("ya se acaba a la clase!!");
        alertDialog.setPositiveButton("YEEEE", (dialogInterface, i) -> {
            Log.d("msg-test", "YEE presionado");
            //
        });
        alertDialog.setNegativeButton("NOOOO", ((dialogInterface, i) -> {
            Log.d("msg-test", "NOOOO presionado");
            //
        }));
        alertDialog.show();
    }

    public void mostrarDialogoConMaterial() {
        MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(this);
        dialogBuilder.setTitle("Ultima clase presencial");
        dialogBuilder.setMessage("nos vemos en 3 años");
        dialogBuilder.setNegativeButton("negativo", (dialogInterface, i) -> Log.d("msg-test","btn negativo"));
        dialogBuilder.setPositiveButton("positivo", (dialogInterface, i) -> Log.d("msg-test","btn posito"));
        dialogBuilder.show();

    }
}