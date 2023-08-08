package com.binnacle.api.repository;

import com.binnacle.api.entity.ProjectEntity;
import com.binnacle.api.repository.contract.IProjectRepository;
import com.binnacle.api.repository.contract.spring.IProjectSpringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProjectRepositoryImpl implements IProjectRepository {
    private final IProjectSpringRepository projectSpringRepository;
    @Override
    public ProjectEntity findByProjectName(String projectName) {
        return projectSpringRepository.findByName(projectName).orElse(null);
    }

    @Override
    public ProjectEntity save(ProjectEntity project) {
        return projectSpringRepository.save(project);
    }

    @Override
    public ProjectEntity findById(int id) {
        return projectSpringRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(ProjectEntity projectEntity) {
        projectSpringRepository.delete(projectEntity);
    }

    @Override
    public List<ProjectEntity> getAllByOwner(String owner) {
        return projectSpringRepository.findByOwner(owner).get();
    }
}