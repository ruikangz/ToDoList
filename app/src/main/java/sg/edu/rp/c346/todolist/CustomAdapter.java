package sg.edu.rp.c346.todolist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CustomAdapter extends ArrayAdapter{

    Context parent_context;
    int layout_id;
    ArrayList<ToDoItem> toDoList;


    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<ToDoItem> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        toDoList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvDate = rowView.findViewById(R.id.textViewDate);
        ImageView ivImpt = rowView.findViewById(R.id.imageView);

        ToDoItem currentItem = toDoList.get(position);
        tvTitle.setText(currentItem.getTitle());
        tvDate.setText(currentItem.getDateString());
        if (currentItem.isImportant()){
            ivImpt.setImageResource(R.drawable.impt);
        }else{
            ivImpt.setImageResource(R.drawable.todo);
        }

        return rowView;
    }
}
