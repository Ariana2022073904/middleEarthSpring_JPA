package com.dnd.character.application.port.input;

import com.dnd.shared.CharacterDTO;
import java.util.List;

public interface GetCharacterUseCase {
    List<CharacterDTO> getAllCharacters();
    List<CharacterDTO> searchCharactersByName(String name);
    CharacterDTO getCharacterById(Long id);
}
