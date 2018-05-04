package pe.edu.unmsm.fisi.upg.ads.cleancode.infrastructure;

import pe.edu.unmsm.fisi.upg.ads.cleancode.domain.IRepository;
import pe.edu.unmsm.fisi.upg.ads.cleancode.domain.Speaker;

public class SqlServerRepository implements IRepository {
	public int saveSpeaker(Speaker speaker) {
		return 1;
	}
}