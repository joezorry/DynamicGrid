package org.askerov.dynamicgrid.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import org.askerov.dynamicgrid.DynamicGridView;
import org.askerov.dynamicgrid.OnDragListenerGridView;

public class GridActivity extends Activity {

    private static final String TAG = GridActivity.class.getName();

    private DynamicGridView gridView1;
    private DynamicGridView gridView2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        gridView1 = (DynamicGridView) findViewById(R.id.dynamic_grid1);

		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.parentLinearLayoutView);


        gridView2 = (DynamicGridView) findViewById(R.id.dynamic_grid2);
        gridView1.setAdapter(new CheeseDynamicAdapter(this,
                new ArrayList<String>(Arrays.asList(Cheeses.sCheeseStrings)),
                getResources().getInteger(R.integer.column_count)));
		gridView2.setAdapter(new CheeseDynamicAdapter(this,
                new ArrayList<String>(Arrays.asList(Cheeses.sCheeseStrings)).subList(0, 5),
                getResources().getInteger(R.integer.column_count)));


		gridView1.setParentView(linearLayout);
		gridView2.setParentView(linearLayout);

//        add callback to stop edit mode if needed
//        gridView.setOnDropListener(new DynamicGridView.OnDropListener()
//        {
//            @Override
//            public void onActionDrop()
//            {
//                gridView.stopEditMode();
//            }
//        });
        gridView1.setOnDragListener(new OnDragListenerGridView() {
			@Override
			public void onDragStarted(int position) {
//                Log.d(TAG, "drag started at position " + position);
			}

			@Override
			public void onDragPositionsChanged(int oldPosition, int newPosition) {
//                Log.d(TAG, String.format("drag item position changed from %d to %d", oldPosition, newPosition));
			}
		});
        gridView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                gridView1.startEditMode(position);
                return true;
            }
        });
		gridView2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                gridView2.startEditMode(position);
                return true;
            }
        });

        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridActivity.this, parent.getAdapter().getItem(position).toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (gridView1.isEditMode()) {
            gridView1.stopEditMode();
        } else {
            super.onBackPressed();
        }
    }
}
