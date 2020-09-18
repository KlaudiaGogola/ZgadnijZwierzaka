package klaudia.gogola.quizapp_zgadnijzwierzaka.AdapterGridView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import klaudia.gogola.quizapp_zgadnijzwierzaka.CardAnimalActivity;
import klaudia.gogola.quizapp_zgadnijzwierzaka.Model.Animal;
import klaudia.gogola.quizapp_zgadnijzwierzaka.Model.Common;
import klaudia.gogola.quizapp_zgadnijzwierzaka.R;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.MyViewHolder> {

    Context context;
    List<Animal> animals;
    int[] image_list = {
            R.drawable.btnlama,
            R.drawable.btndelfin,
            R.drawable.btnflaming,
            R.drawable.btnhipo,
            R.drawable.btnkaczka,
            R.drawable.btnkangur,
            R.drawable.btnkoala,
            R.drawable.btnkot,
            R.drawable.btnkrokodyl,
            R.drawable.btnkrolik,
            R.drawable.btnlew,
            R.drawable.btnlis,
            R.drawable.btnmalpa,
            R.drawable.btnmisiek,
            R.drawable.btnpanda,
            R.drawable.btnpies,
            R.drawable.btnpingwin,
            R.drawable.btnsarna,
            R.drawable.btnslon,
            R.drawable.btnszop,
            R.drawable.btntygrys,
            R.drawable.btnsnake,
            R.drawable.btnzyrafa

    };

    public ViewAdapter(Context context, List<Animal> animals) {
        this.context = context;
        this.animals = animals;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.from(context).inflate(R.layout.item_card,viewGroup,false);
            return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
            myViewHolder.imageAnimal.setImageResource(image_list[i]);
    }

    @Override
    public int getItemCount() {
        return image_list.length;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardAnimal;
        ImageView imageAnimal;


        public MyViewHolder(View itemView) {
            super(itemView);
            cardAnimal = (CardView) itemView.findViewById(R.id.card_category);
            imageAnimal = (ImageView) itemView.findViewById(R.id.imageAnimal);

            cardAnimal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Common.selectedAnimal = animals.get(getAdapterPosition());
                    Intent intent = new Intent(context, CardAnimalActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }



}
