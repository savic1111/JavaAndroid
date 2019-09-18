package l.com.example.academy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.ref.SoftReference;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {

    private TextView txtInfo,txtInfo1,txtInfo2;


    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_user, container, false);

        txtInfo=view.findViewById(R.id.txt_display_info);
        txtInfo1=view.findViewById(R.id.NAME);
        txtInfo2=view.findViewById(R.id.MAIL);


        List<User> users = mm.myAppDatabase.myDao().getUsers();


        String info = "";
        String info1 = "";
        String info2 = "";

        for(User usr:users)
        {
            int id = usr.getId();
            String name = usr.getName();
            String email = usr.getEmail();

            info = info+"\n\n"+"" + id;
            info1 = info1+"\n\n"+ ""+ name;
            info2 = info2+"\n\n"+""+email;

        }
        txtInfo.setText(info);
        txtInfo1.setText(info1);
        txtInfo2.setText(info2);
        return view;
    }

}
