package fr.isen.valdezalvarez.diegodroitburger;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ViewInfoActivity extends AppCompatActivity {
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String number;
    private String burger;
    private Button sendmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_info);

        sendmail = findViewById(R.id.smail);



        /*
        nom=(TextView) findViewById(R.id.nom);
        prenom=(TextView) findViewById(R.id.prenom);
        email=(TextView) findViewById(R.id.email);
        adresse=(TextView) findViewById(R.id.adresse);
        number=(TextView) findViewById(R.id.number);

        // Recup des données.
        Intent intent = getIntent();

        nom.setText(intent.getStringExtra("nom"));
        prenom.setText(intent.getStringExtra("prenom"));
        email.setText(intent.getStringExtra("email"));
        adresse.setText(intent.getStringExtra("adresse"));
        number.setText(intent.getStringExtra("numero"));
        burger.setText(intent.getStringExtra("burger"));
        */
        Intent intent = getIntent();

        nom = intent.getStringExtra("nom");
        prenom = intent.getStringExtra("prenom");
        email = intent.getStringExtra("email");
        adresse = intent.getStringExtra("adresse");
        number = intent.getStringExtra("numero");
        burger = intent.getStringExtra("burger");

        TextView name = findViewById(R.id.name);
        name.setText(nom);

        TextView firstname = findViewById(R.id.firstname);
        firstname.setText(prenom);

        TextView mail = findViewById(R.id.mail);
        mail.setText(email);

        TextView adr = findViewById(R.id.address);
        adr.setText(adresse);

        TextView nbr = findViewById(R.id.sexYesOrNo);
        nbr.setText(number);

        TextView burg = findViewById(R.id.burger);
        burg.setText(burger);


         sendmail.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Intent sendmailIntent = new Intent(Intent.ACTION_SEND);
                 sendmailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"marc.mollinari@gmail.com"});
                 sendmailIntent.putExtra(Intent.EXTRA_SUBJECT, "Confirmation commande");
                 sendmailIntent.putExtra(Intent.EXTRA_TEXT, "Votre commande a bien été enregistrée");
                 startActivity(Intent.createChooser(sendmailIntent, "Choose an Email client :"));

             }
         });

    }
    public void ReturnBack(View view) {
        Intent intent = new Intent(getApplicationContext(), RegisterUserandBurger.class);
        finish();
        startActivity(intent);
    }

}