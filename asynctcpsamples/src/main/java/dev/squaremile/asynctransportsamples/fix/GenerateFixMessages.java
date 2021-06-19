package dev.squaremile.asynctransportsamples.fix;

import uk.co.real_logic.artio.dictionary.generation.CodecConfiguration;
import uk.co.real_logic.artio.dictionary.generation.CodecGenerator;

public final class GenerateFixMessages
{
    public static void main(final String[] args)
    {
        try
        {
            CodecGenerator.generate(new CodecConfiguration().outputPath(args[0]).fileNames(args[1].split(";")).parentPackage(args[2]));
        }
        catch (final Throwable e)
        {
            e.printStackTrace();
            System.err.println("Usage: GenerateFixMessages <path/to/output> <[path/to/dictionary2.xml;]path/to/dictionary.xml> <package.name>");
            System.exit(-1);
        }
    }

}
