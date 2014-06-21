package co.edu.udea.compumovil.ahorcatooth.persistance.sqlite.dao;

import android.content.ContentValues;

public interface IHangmanWordDAO {

	public Integer deleteHangmanWord(Long id);

	public ContentValues saveHangmanWord(ContentValues hangmanWordContentValues);
}