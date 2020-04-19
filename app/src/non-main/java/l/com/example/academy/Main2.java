package l.com.example.academy;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.util.Pair;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;

public class Main2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv); // layout reference

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true); // to improve performance

        rv.setAdapter(new DataManager()); // the data manager is assigner to the RV
        rv.addOnItemTouchListener( // and the click is handled
                new RecyclerClickListener(this, new RecyclerClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(Main2.this, details.class);
                        intent.putExtra(details.ID, Contact.CONTACTS[position].getId());

                        ActivityOptionsCompat options;
                        options = (ActivityOptionsCompat) ActivityOptionsCompat.makeSceneTransitionAnimation(
                                // the context of the activity
                                Main2.this,

                                // For each shared element, add to this method a new Pair item,
                                // which contains the reference of the view we are transitioning *from*,
                                // and the value of the transitionName attribute
                                new Pair<View, String>(view.findViewById(R.id.CONTACT_circle),
                                        getString(R.string.transition_name_circle)),
                                new Pair<View, String>(view.findViewById(R.id.CONTACT_name),
                                        getString(R.string.transition_name_name)),
                                new Pair<View, String>(view.findViewById(R.id.CONTACT_phone),
                                        getString(R.string.transition_name_phone))
                        );
                        ActivityCompat.startActivity(Main2.this, intent, options.toBundle());
                        // STUB:
                        // The click on the item must be handled

                    }
                }));

    }
}
