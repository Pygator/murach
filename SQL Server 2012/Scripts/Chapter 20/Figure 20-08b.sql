USE MusicStore;

SELECT ImageID, ProductImage.PathName() AS FileStreamPath
FROM ProductImages;