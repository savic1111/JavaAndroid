package l.com.example.academy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteUserFragment extends Fragment {

    private EditText txEdit;
    private Button DeleteButton;


    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);
        txEdit = view.findViewById(R.id.delete2);
        DeleteButton = view.findViewById(R.id.delete3);
DeleteButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        int id = Integer.parseInt(txEdit.getText().toString());
        User user = new User();
        user.setId(id);
        mm.myAppDatabase.myDao().deleteUser(user);

        Toast.makeText(getActivity(),"Успешно удалено",Toast.LENGTH_SHORT).show();
        txEdit.setText("");

    }
});
        return view;
    }

}
