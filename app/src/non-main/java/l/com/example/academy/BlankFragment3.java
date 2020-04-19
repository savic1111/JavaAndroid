package l.com.example.academy;


import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment3 extends ListFragment {
    String classID;
    SimpleCursorAdapter userAdapter;

    Cursor userCursor;
    ListView mList;


    public BlankFragment3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        View rootview = inflater.inflate(R.layout.fragment_blank_fragment3,container,false);
        mList = (ListView) rootview.findViewById(android.R.id.list);
        return rootview;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getActivity().getIntent().getExtras();
        classID = bundle.getString("classID");


    }
    @Override
    public void onResume() {
        super.onResume();
        try {


            String[]headers = new String[]
                    {

                    };
            userAdapter = new SimpleCursorAdapter(getActivity(),R.layout.item,userCursor,headers,new int[]{R.id.urok1},0);
            mList.setAdapter(userAdapter);

        } catch (SQLException ex) {
        }
    }

}
