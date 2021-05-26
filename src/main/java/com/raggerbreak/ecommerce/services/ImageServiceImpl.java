package com.raggerbreak.ecommerce.services;

import com.raggerbreak.ecommerce.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    public byte[] getImage(Long id) {

        return imageRepository.findById(id)
                .orElse(null)
                .getImageByte();
    }
}
