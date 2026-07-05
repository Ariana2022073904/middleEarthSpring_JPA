package com.dnd.character.infrastructure.adapter.outbound;

import com.dnd.character.domain.model.DnDCharacter;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterJpaRepository extends JpaRepository<DnDCharacter, Long> {
    List<DnDCharacter> findByNameContainingIgnoreCase(String name);
}
