package co.edu.udea.compumovil.ahorcatooth.process.webservice.interfaces;

import java.util.List;

import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;

public interface ICategoryWSResultListener {

	public List<Category> categoryWSResultListener(List<Category> categoriesList);
}