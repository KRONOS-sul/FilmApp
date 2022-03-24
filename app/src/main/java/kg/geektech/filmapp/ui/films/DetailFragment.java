package kg.geektech.filmapp.ui.films;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import kg.geektech.filmapp.App;
import kg.geektech.filmapp.data.models.Film;
import kg.geektech.filmapp.databinding.FragmentDetailBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailFragment extends Fragment {

private FragmentDetailBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String id = getArguments().getString("id");

        App.api.getFilmDetail(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful()){
                    Film film = response.body();
                    //assert film !=null;
                    binding.title.setText(film.getTitle());
                    binding.description.setText(film.getDescription());
                    binding.originalTitle.setText(film.getOriginal_title());
                    binding.releaseDate.setText(film.getRelease_date());
                    binding.director.setText(film.getDirector());
                    Glide.with(requireActivity()).load(film.getImage()).into(binding.imageUrl);
                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {

            }
        });
    }
}