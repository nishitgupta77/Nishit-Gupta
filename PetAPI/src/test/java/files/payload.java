package files;

import java.util.ArrayList;
import java.util.List;

import pojo.Category;
import pojo.Pet;
import pojo.Tag;

public class payload {
	
	public static Pet AddPetRequestPayload()
	{
		Pet pet = new Pet();
		pet.setId(10);
		pet.setName("Pubi");
		Category cat = new Category();
		cat.setId(1);
		cat.setName("Dogs");
		pet.setCategory(cat);
		List<String> photo = new ArrayList<String>();
		photo.add("string");
		pet.setPhotoUrls(photo);
		Tag tag = new Tag();
		tag.setId(1);
		tag.setName("string");
		pet.setStatus("available");
			return pet;
	}
	
	public static Pet UpdatePetRequestPayload()
	{
		Pet pet = new Pet();
		pet.setId(10);
		pet.setName("Honey");
		Category cat = new Category();
		cat.setId(1);
		cat.setName("Dogs");
		cat.setId(2);
		cat.setName("Cats");
		pet.setCategory(cat);
		List<String> photo = new ArrayList<String>();
		photo.add("string");
		pet.setPhotoUrls(photo);
		Tag tag = new Tag();
		tag.setId(1);
		tag.setName("string");
		pet.setStatus("available");
			return pet;
	}

}
