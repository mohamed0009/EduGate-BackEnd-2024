package BackEnd.EduGate.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<NoteDTO> getNotes() {
        return noteRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public void addNewNote(Note note) {
        noteRepository.save(note);
    }

    public void deleteNote(Long noteId) {
        boolean exists = noteRepository.existsById(noteId);
        if (!exists) {
            throw new IllegalStateException("Note with id " + noteId + " does not exist.");
        }
        noteRepository.deleteById(noteId);
    }

    private NoteDTO convertToDTO(Note note) {
        return new NoteDTO(
                note.getIdNote(),
                note.getMatiere(),
                note.getNote(),
                note.getEleve().getIdEleve(),
                note.getEleve().getClasse().getNomClasse(), // Including class name in DTO
                note.getEnseignant().getIdProf(),
                note.getEnseignant().getUtilisateur().getNom());
    }
}
