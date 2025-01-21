package dobarbobar.com.knote_k8s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KnoteK8sApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnoteK8sApplication.class, args);
	}

}

@Document(collection = "notes")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
class Note {
    @Id
    private String id;
    private String description;

    @Override
    public String toString() {
        return description;
    }
}

interface NotesRepository extends MongoRepository<Note, String> {

}

@Controller
class KNoteController {

    @Autowired
    private NotesRepository notesRepository;
	
	@GetMapping("/")
    public String index(Model model) {
        getAllNotes(model);
        return "index";
    }

    private void getAllNotes(Model model) {
        List<Note> notes = notesRepository.findAll();
        Collections.reverse(notes);
        model.addAttribute("notes", notes);
    }
	
	private void saveNote(String description, Model model) {
	  if (description != null && !description.trim().isEmpty()) {
		notesRepository.save(new Note(null, description.trim()));
		//After publish you need to clean up the textarea
		model.addAttribute("description", "");
  }
}

}