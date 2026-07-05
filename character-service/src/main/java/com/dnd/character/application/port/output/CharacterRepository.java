package com.dnd.character.application.port.output;

import com.dnd.character.domain.model.DnDCharacter;
import java.util.List;
import java.util.Optional;

public interface CharacterRepository {
    DnDCharacter save(DnDCharacter character);
    List<DnDCharacter> findAll();
    List<DnDCharacter> findByNameContainingIgnoreCase(String name);
    Optional<DnDCharacter> findById(Long id);
}
