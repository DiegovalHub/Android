package fr.isen.valdezalvarez.diegodroitburger;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.os.Bundle;
import android.widget.Toast;
import android.view.inputmethod.InputMethodManager;


import androidx.appcompat.app.AppCompatActivity;


public class RegisterUserandBurger extends AppCompatActivity {
    private Button enregistrer;
    private EditText nom;
    private EditText prenom;
    private EditText email;
    private EditText adresse;
    private EditText number;

    private Spinner hour;
    private Spinner minute;
    private Spinner numbers;
    private Spinner burger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_userand_burger);

        enregistrer = (Button) findViewById(R.id.save);

        nom = (EditText) findViewById(R.id.nom);
        prenom = (EditText) findViewById(R.id.prenom);
        email = (EditText) findViewById(R.id.email);
        adresse = (EditText) findViewById(R.id.adresse);
        number = (EditText) findViewById(R.id.number);

        hour = (Spinner) findViewById(R.id.view_hour);
        minute = (Spinner) findViewById(R.id.view_minute);
        numbers = (Spinner) findViewById(R.id.numberburger);
        burger = (Spinner) findViewById(R.id.burgerlist);

        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_nom = "";
                String str_prenom = "";
                String str_email = "";
                String str_adresse = "";
                String str_heure_livre = "";
                String str_burger = "";

                int int_number = 0;
                String int_hour = "0";
                String int_minute = "0";
                String int_numbers = "0";

                //confirmation
                boolean info_valable = true;
                // rajouter le test de burger vide
                if (!nom.getText().toString().trim().equals("")) {
                    str_nom = nom.getText().toString().trim();
                } else {
                    info_valable = false;
                }
                if (!prenom.getText().toString().trim().equals("")) {
                    str_prenom = prenom.getText().toString().trim();
                } else {
                    info_valable = false;
                }
                if (!email.getText().toString().trim().equals("")) {
                    str_email = email.getText().toString().trim();
                }else{
                    info_valable = false;
                }
                if(!adresse.getText().toString().trim().equals("")){
                    str_adresse = adresse.getText().toString().trim();
                } else {
                    info_valable = false;
                }
                if (!number.getText().toString().trim().equals("")) {
                    // int_number=Integer.parseInt(String.valueOf(number)); //doute
                }
                str_burger = burger.getSelectedItem().toString();         //doute
                int_hour = hour.getSelectedItem().toString();
                int_minute = minute.getSelectedItem().toString();
                int_numbers = numbers.getSelectedItem().toString();

                str_heure_livre = int_hour + "H" + int_minute + "m";

                //ça masque le clavier ??
                //InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                if (info_valable == false) {
                    Toast.makeText(getApplicationContext(), "Il manque des informations", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), ViewInfoActivity.class);
                    intent.putExtra("nom", str_nom);
                    intent.putExtra("prenom", str_prenom);
                    intent.putExtra("email", str_email);
                    intent.putExtra("Heure", str_heure_livre);
                    intent.putExtra("numero", int_number);
                    intent.putExtra("adresse", str_adresse);
                    intent.putExtra("burger", str_burger);
                    intent.putExtra("numero", int_numbers);
                    //finish();
                    startActivity(intent);

                }

            }
        });
    }
}