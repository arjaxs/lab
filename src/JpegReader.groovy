import org.apache.sanselan.ImageReadException
import org.apache.sanselan.Sanselan
import org.apache.sanselan.common.byteSources.ByteSource
import org.apache.sanselan.common.byteSources.ByteSourceFile
import org.apache.sanselan.formats.jpeg.JpegImageParser
import org.apache.sanselan.formats.jpeg.segments.UnknownSegment

import javax.imageio.IIOException
import javax.imageio.ImageIO
import javax.imageio.ImageReader
import javax.imageio.stream.ImageInputStream
import java.awt.color.ColorSpace
import java.awt.color.ICC_ColorSpace
import java.awt.color.ICC_Profile
import java.awt.image.BufferedImage
import java.awt.image.ColorConvertOp
import java.awt.image.Raster
import java.awt.image.WritableRaster

public class JpegReader {

    public static final int COLOR_TYPE_RGB = 1;
    public static final int COLOR_TYPE_CMYK = 2;
    public static final int COLOR_TYPE_YCCK = 3;

    private int colorType = COLOR_TYPE_RGB;
    private boolean hasAdobeMarker = false;
    public static void main(String[] args) {
        try {
            File file=new File("C:\\work\\sprints\\sprint12\\cmyk\\cmyk-encoded-image.jpg");
            JpegReader j=new JpegReader()
            j.readImage(file);
        } catch (Exception e) {
            e.printStackTrace()
        }

        /*ImageInfo info = new ImageInfo("myImage.jpg");
        boolean isCMYK = info.getColorspace() == ColorspaceType.CMYKColorspace;
        if(isCMYK) {
            info.setColorspace(ColorspaceType.RGBColorspace);
        }
        mageInfo info = new ImageInfo(pathToImageFile);
        info.setColorspace(ColorspaceType.RGBColorspace);
        MagickImage img = new MagickImage(info);
        img.setFileName(someOtherPath);
        img.writeImage(info);*/

    }


    public BufferedImage readImage(File file) throws IOException, ImageReadException {
        colorType = COLOR_TYPE_RGB;
        hasAdobeMarker = false;


        BufferedImage image;
        ImageInputStream stream = ImageIO.createImageInputStream(file);
        Iterator<ImageReader> iter = ImageIO.getImageReaders(stream);
        while (iter.hasNext()) {
            ImageReader reader = iter.next();
            reader.setInput(stream);


            ICC_Profile profile = null;
            try {
                image = reader.read(0);
            } catch (IIOException e) {
                colorType = COLOR_TYPE_CMYK;
                checkAdobeMarker(file);
                profile = Sanselan.getICCProfile(file);
                WritableRaster raster = (WritableRaster) reader.readRaster(0, null);
                if (colorType == COLOR_TYPE_YCCK)
                    convertYcckToCmyk(raster);
                if (hasAdobeMarker)
                    convertInvertedColors(raster);
                image = convertCmykToRgb(raster, profile);
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                try {
                    // retrieve image

                    File outputfile = new File("saved.jpg");
                    ImageIO.write(image, "jpg", outputfile);
                } catch (IOException es) {
es.printStackTrace()
                }
                ImageIO.write(image, "jpeg", os);
                InputStream is = new ByteArrayInputStream(os.toByteArray());
                ImageIO.read(is)

            }


        }

        return null;
    }

    public void checkAdobeMarker(File file) throws IOException, ImageReadException {
        JpegImageParser parser = new JpegImageParser();
        ByteSource byteSource = new ByteSourceFile(file);
        @SuppressWarnings("rawtypes")

        int[] a = [0xffee]
        ArrayList segments = parser.readSegments(byteSource,a, true);
        if (segments != null && segments.size() >= 1) {
            UnknownSegment app14Segment = (UnknownSegment) segments.get(0);
            byte[] data = app14Segment.bytes;
            if (data.length >= 12 && data[0] == 'A' && data[1] == 'd' && data[2] == 'o' && data[3] == 'b' && data[4] == 'e')
            {
                hasAdobeMarker = true;
                int transform = app14Segment.bytes[11] & 0xff;
                if (transform == 2)
                    colorType = COLOR_TYPE_YCCK;
            }
        }
    }

    public static void convertYcckToCmyk(WritableRaster raster) {
        int height = raster.getHeight();
        int width = raster.getWidth();
        int stride = width * 4;
        int[] pixelRow = new int[stride];
        for (int h = 0; h < height; h++) {
            raster.getPixels(0, h, width, 1, pixelRow);

            for (int x = 0; x < stride; x += 4) {
                int y = pixelRow[x];
                int cb = pixelRow[x + 1];
                int cr = pixelRow[x + 2];

                int c = (int) (y + 1.402 * cr - 178.956);
                int m = (int) (y - 0.34414 * cb - 0.71414 * cr + 135.95984);
                y = (int) (y + 1.772 * cb - 226.316);

                if (c < 0) c = 0; else if (c > 255) c = 255;
                if (m < 0) m = 0; else if (m > 255) m = 255;
                if (y < 0) y = 0; else if (y > 255) y = 255;

                pixelRow[x] = 255 - c;
                pixelRow[x + 1] = 255 - m;
                pixelRow[x + 2] = 255 - y;
            }

            raster.setPixels(0, h, width, 1, pixelRow);
        }
    }

    public static void convertInvertedColors(WritableRaster raster) {
        int height = raster.getHeight();
        int width = raster.getWidth();
        int stride = width * 4;
        int[] pixelRow = new int[stride];
        for (int h = 0; h < height; h++) {
            raster.getPixels(0, h, width, 1, pixelRow);
            for (int x = 0; x < stride; x++)
                pixelRow[x] = 255 - pixelRow[x];
            raster.setPixels(0, h, width, 1, pixelRow);
        }
    }

    public static BufferedImage convertCmykToRgb(Raster cmykRaster, ICC_Profile cmykProfile) throws IOException {
        if (cmykProfile == null){
            def p = ~/.*\.icc/
            new File( 'C:\\Cheqqer\\Lab\\icc\\icc\\CMYK' ).eachFileMatch(p){it->
          try {
              cmykProfile = ICC_Profile.getInstance(new FileInputStream(it.path));
          }catch(Exception e){
              println it
              e.printStackTrace()
          }
        }}
        cmykProfile = ICC_Profile.getInstance(new FileInputStream("C:\\Cheqqer\\Lab\\icc\\ISOcoated_v2_300_eci.icc"));


        ICC_ColorSpace cmykCS = new ICC_ColorSpace(cmykProfile);
        BufferedImage rgbImage = new BufferedImage(cmykRaster.getWidth(), cmykRaster.getHeight(), BufferedImage.TYPE_INT_RGB);
        WritableRaster rgbRaster = rgbImage.getRaster();
        ColorSpace rgbCS = rgbImage.getColorModel().getColorSpace();
        ColorConvertOp cmykToRgb = new ColorConvertOp(cmykCS, rgbCS, null);
        cmykToRgb.filter(cmykRaster, rgbRaster);
        return rgbImage;
    }
}